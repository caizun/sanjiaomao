package xyz.sanjiaomao.infrastructure.auth;

import cn.hutool.core.lang.Assert;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import xyz.sanjiaomao.infrastructure.account.dataobject.AccountRoleRelDO;
import xyz.sanjiaomao.infrastructure.account.dataobject.RoleDO;
import xyz.sanjiaomao.infrastructure.account.qry.RoleQry;
import xyz.sanjiaomao.infrastructure.constants.AccountConstant;
import xyz.sanjiaomao.infrastructure.mapper.AccountRoleRelMapper;
import xyz.sanjiaomao.infrastructure.mapper.RoleMapper;
import xyz.sanjiaomao.infrastructure.message.Message;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-14 22:41
 */
@Aspect
@Component
public class RoleAop {

  @Resource
  public HttpServletRequest request;

  @Resource
  public AccountRoleRelMapper accountRoleRelMapper;

  @Resource
  public RoleMapper roleMapper;


  @Pointcut("@annotation(xyz.sanjiaomao.infrastructure.auth.Role)")
  public void point() {
  }


  @Before("point()")
  public void before(JoinPoint joinPoint) {
    Signature signature = joinPoint.getSignature();
    MethodSignature methodSignature = (MethodSignature) signature;
    Method targetMethod = methodSignature.getMethod();
    Role annotation = targetMethod.getAnnotation(Role.class);
    Object id = request.getAttribute(AccountConstant.ID);

    Assert.isTrue(Objects.nonNull(id), Message.NO_AUTHENTICATION);
    Boolean result = CompletableFuture.supplyAsync(() -> {
      List<AccountRoleRelDO> listAccountRoleRel = accountRoleRelMapper.selectByAccountId((Long) id);
      return listAccountRoleRel.stream().map(AccountRoleRelDO::getRoleId).collect(Collectors.toList());
    }).thenCombineAsync(CompletableFuture.supplyAsync(() -> {
      String value = annotation.value();
      RoleQry qry = new RoleQry();
      qry.setRoleCode(value);
      return roleMapper.select(qry).stream().findFirst().orElse(new RoleDO());
    }), (x, y) -> x.contains(y.getId())).join();

    Assert.isTrue(result, Message.NO_AUTHENTICATION);

  }


}

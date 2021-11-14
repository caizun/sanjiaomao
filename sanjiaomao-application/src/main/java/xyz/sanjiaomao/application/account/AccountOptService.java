package xyz.sanjiaomao.application.account;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.domain.account.AccountAggregate;
import xyz.sanjiaomao.domain.account.cmd.AccountCmd;
import xyz.sanjiaomao.domain.account.cmd.CreateAccountCmd;
import xyz.sanjiaomao.domain.account.repository.AccountRepository;
import xyz.sanjiaomao.infrastructure.account.dataobject.AccountDO;
import xyz.sanjiaomao.infrastructure.account.dataobject.RoleDO;
import xyz.sanjiaomao.infrastructure.constants.AccountConstant;
import xyz.sanjiaomao.infrastructure.message.Message;
import xyz.sanjiaomao.infrastructure.utils.CacheAccountRecordUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 16:14
 */
@Service
public class AccountOptService {

  @Resource
  private AccountRepository accountRepository;

  @Resource
  private AccountQryService accountQryService;

  @Resource
  private RoleQryService roleQryService;

  @Resource
  private HttpServletRequest httpServletRequest;

  @Resource
  private HttpServletResponse httpServletResponse;


  @Transactional(rollbackFor = Exception.class)
  public void registry(CreateAccountCmd cmd) {
    //阅读模型
    AccountDO accountDO = accountQryService.selectByAccount(cmd.getAccountName());
    RoleDO roleDO = roleQryService.selectByRoleCode(AccountConstant.ROLE_NORMAL);
    //断言
    Assert.isNull(accountDO.getId(), Message.EXIST_ACCOUNT);
    Assert.notNull(roleDO.getId(), Message.NOT_EXIST_ROLE);
    Assert.isTrue(Objects.equals(cmd.getPassword(), cmd.getRePassword()), Message.ERROR_PASSWORD);
    //创建聚合
    AccountAggregate aggregate = accountRepository.create(cmd);
    //初始化角色
    aggregate.addRole(roleDO.getId());
    accountRepository.save(aggregate);
  }


  public void login(AccountCmd cmd) {
    AccountDO accountDO = accountQryService.selectByAccount(cmd.getAccountName());
    //断言
    Assert.notNull(accountDO.getId(), Message.NOT_EXIST_ACCOUNT);
    Assert.isTrue(Objects.equals(accountDO.getPassword(), cmd.getPassword()), Message.ERROR_PASSWORD);

    String id = IdUtil.simpleUUID();

    CacheAccountRecordUtils.put(id, accountDO);


    Cookie account = new Cookie(AccountConstant.COOKIE_ACCOUNT, id);
    account.setMaxAge(Integer.MAX_VALUE);

    httpServletResponse.addCookie(account);

  }

}

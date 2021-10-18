package xyz.sanjiaomao.application.account;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import xyz.sanjiaomao.infrastructure.account.dataobject.RoleDO;
import xyz.sanjiaomao.infrastructure.account.qry.RoleQry;
import xyz.sanjiaomao.infrastructure.mapper.RoleMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 16:15
 */
@Service
public class RoleQryService {

  @Resource
  private RoleMapper roleMapper;


  public RoleDO selectByRoleCode(String roleNormal) {
    RoleQry qry = new RoleQry();
    qry.setRoleCode(roleNormal);
    List<RoleDO> listRoleDO = select(qry);
    return CollectionUtils.isEmpty(listRoleDO)?new RoleDO():listRoleDO.get(0);
  }


  public List<RoleDO> select(RoleQry qry) {
    return roleMapper.select(qry);
  }
}

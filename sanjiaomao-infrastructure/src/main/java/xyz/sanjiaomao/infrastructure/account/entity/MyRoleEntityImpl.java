package xyz.sanjiaomao.infrastructure.account.entity;

import xyz.sanjiaomao.domain.account.entity.MyRoleEntity;
import xyz.sanjiaomao.infrastructure.account.dataobject.AccountRoleRelDO;
import xyz.sanjiaomao.infrastructure.mapper.AccountRoleRelMapper;
import xyz.sanjiaomao.infrastructure.mapper.RoleMapper;
import xyz.sanjiaomao.infrastructure.utils.IdUtils;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 17:10
 */
public class MyRoleEntityImpl implements MyRoleEntity {


  public final RoleMapper roleMapper;

  public final AccountRoleRelMapper accountRoleRelMapper;

  public MyRoleEntityImpl(RoleMapper roleMapper, AccountRoleRelMapper accountRoleRelMapper){
    this.roleMapper = roleMapper;
    this.accountRoleRelMapper = accountRoleRelMapper;
  }

  @Override
  public void create(Long accountId, Long roleId) {
    AccountRoleRelDO accountRoleRelDO = new AccountRoleRelDO();
    accountRoleRelDO.setId(IdUtils.AccountRoleId.nextId());
    accountRoleRelDO.setAccountId(accountId);
    accountRoleRelDO.setRoleId(roleId);
    accountRoleRelMapper.insert(accountRoleRelDO);
  }
}

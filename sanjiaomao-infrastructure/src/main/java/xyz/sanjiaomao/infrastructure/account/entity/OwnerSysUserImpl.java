package xyz.sanjiaomao.infrastructure.account.entity;

import xyz.sanjiaomao.domain.account.entity.OwnerSysUser;
import xyz.sanjiaomao.domain.account.entity.SysUserEntity;
import xyz.sanjiaomao.infrastructure.mapper.SysUserDAOMapper;

/**
 * <pre>
 *  账号归属人
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-02 20:53
 */
public class OwnerSysUserImpl implements OwnerSysUser {

  private final SysUserDAOMapper mapper;

  public OwnerSysUserImpl(SysUserDAOMapper mapper) {
    this.mapper = mapper;
  }


  @Override
  public SysUserEntity findByAccountId(Long accountId) {
    return null;
  }
}

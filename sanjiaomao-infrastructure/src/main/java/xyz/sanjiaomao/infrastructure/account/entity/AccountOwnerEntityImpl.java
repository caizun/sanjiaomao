package xyz.sanjiaomao.infrastructure.account.entity;

import xyz.sanjiaomao.domain.account.entity.AccountOwnerEntity;
import xyz.sanjiaomao.infrastructure.mapper.UserMapper;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 17:17
 */
public class AccountOwnerEntityImpl implements AccountOwnerEntity {

  private final UserMapper userMapper;

  public AccountOwnerEntityImpl(UserMapper userMapper){
    this.userMapper = userMapper;
  }
}

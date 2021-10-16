package xyz.sanjiaomao.domain.account.repository;

import xyz.sanjiaomao.domain.account.AccountAggregate;
import xyz.sanjiaomao.domain.account.cmd.CreateAccountCmd;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 16:23
 */
public interface AccountRepository {
  /**
   * 创建聚合根
   * @param cmd {@link CreateAccountCmd}
   * @return {@link AccountAggregate}
   */
  AccountAggregate create(CreateAccountCmd cmd);

  void save(AccountAggregate aggregate);

  AccountAggregate findById(Long id);
}

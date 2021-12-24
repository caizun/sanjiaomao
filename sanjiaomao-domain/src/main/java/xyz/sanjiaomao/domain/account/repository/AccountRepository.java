package xyz.sanjiaomao.domain.account.repository;

import xyz.sanjiaomao.domain.account.AccountAggregate;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-12-23 01:10
 */
public interface AccountRepository {
  void save(AccountAggregate aggregate);
}

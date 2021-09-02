package xyz.sanjiaomao.domain.account.repository;

import xyz.sanjiaomao.domain.account.AccountBO;

/**
 * <pre>
 * 账号仓储
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-02 20:51
 */
public interface AccountRepository {


  AccountBO findByAccount(String account);

  void create(AccountBO accountBO);
}

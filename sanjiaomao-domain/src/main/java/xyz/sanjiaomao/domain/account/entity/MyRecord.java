package xyz.sanjiaomao.domain.account.entity;

import xyz.sanjiaomao.domain.account.AccountBO;

/**
 * <pre>
 *  我的登录记录
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-02 22:00
 */
public interface MyRecord {



  void add(AccountBO bo);
}

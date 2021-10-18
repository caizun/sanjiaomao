package xyz.sanjiaomao.domain.account.entity;

import xyz.sanjiaomao.domain.account.AccountAggregate;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-18 20:50
 */
public interface MyRecordEntity {
  void addRecord(String recordId, AccountAggregate aggregate);

  void delRecord(String recordId);
}

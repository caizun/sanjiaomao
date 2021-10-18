package xyz.sanjiaomao.infrastructure.account.entity;

import xyz.sanjiaomao.domain.account.AccountAggregate;
import xyz.sanjiaomao.domain.account.entity.MyRecordEntity;
import xyz.sanjiaomao.infrastructure.utils.CacheAccountRecordUtils;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-18 20:52
 */
public class MyRecordEntityImpl implements MyRecordEntity {


  @Override
  public void addRecord(String recordId, AccountAggregate aggregate) {
    CacheAccountRecordUtils.put(recordId, aggregate);
  }

  @Override
  public void delRecord(String recordId) {
    CacheAccountRecordUtils.remove(recordId);
  }
}

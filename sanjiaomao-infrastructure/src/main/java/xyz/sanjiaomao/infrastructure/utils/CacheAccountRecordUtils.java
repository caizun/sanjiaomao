package xyz.sanjiaomao.infrastructure.utils;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.CacheObj;
import cn.hutool.cache.impl.TimedCache;
import xyz.sanjiaomao.domain.account.AccountAggregate;

import java.util.Iterator;
import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 16:18
 */
public class CacheAccountRecordUtils {

  private static final TimedCache<String, AccountAggregate> CACHE_LOGIN = CacheUtil.newTimedCache(300000);

  private static final Cache<String, AccountAggregate> REFRESH_LOGIN = CacheUtil.newLRUCache(Integer.MAX_VALUE);


  public static AccountAggregate get(String key) {
    return CACHE_LOGIN.get(key);
  }

  public static void put(String key, AccountAggregate aggregate) {
    synchronized (CACHE_LOGIN) {
      CACHE_LOGIN.put(key, aggregate);
    }
  }


  public static void put(String key, AccountAggregate aggregate, long expire) {
    synchronized (CACHE_LOGIN) {
      CACHE_LOGIN.put(key, aggregate, expire);
    }
  }

  public static void remove(String key) {
    CACHE_LOGIN.remove(key);
  }


  public static AccountAggregate getRefresh(String key) {
    return REFRESH_LOGIN.get(key);
  }

  public static void putRefresh(String key, AccountAggregate aggregate) {
    synchronized (REFRESH_LOGIN) {
      Iterator<CacheObj<String, AccountAggregate>> cacheObjIterator = REFRESH_LOGIN.cacheObjIterator();
      while (cacheObjIterator.hasNext()) {
        CacheObj<String, AccountAggregate> next = cacheObjIterator.next();
        AccountAggregate value = next.getValue();
        if (Objects.equals(value.getId(), aggregate.getId())) {
          REFRESH_LOGIN.remove(next.getKey());
        }
      }
      REFRESH_LOGIN.put(key, aggregate);
    }
  }

  public static void removeRefresh(String key) {
    REFRESH_LOGIN.remove(key);
  }


}

package xyz.sanjiaomao.infrastructure.utils;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import xyz.sanjiaomao.infrastructure.account.dataobject.AccountDO;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 16:18
 */
public class CacheAccountRecordUtils {

  private static final TimedCache<String, AccountDO> CACHE_LOGIN = CacheUtil.newTimedCache(300000);


  public static AccountDO get(String key) {
    return CACHE_LOGIN.get(key);
  }

  public static void put(String key, AccountDO accountDO) {
    synchronized (CACHE_LOGIN) {
      CACHE_LOGIN.put(key, accountDO);
    }
  }


  public static void put(String key, AccountDO aggregate, long expire) {
    synchronized (CACHE_LOGIN) {
      CACHE_LOGIN.put(key, aggregate, expire);
    }
  }

  public static void remove(String key) {
    CACHE_LOGIN.remove(key);
  }


}

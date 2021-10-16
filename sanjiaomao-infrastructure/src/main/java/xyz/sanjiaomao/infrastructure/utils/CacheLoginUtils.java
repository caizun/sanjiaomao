package xyz.sanjiaomao.infrastructure.utils;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import xyz.sanjiaomao.infrastructure.account.dataobject.AccountDO;

import java.util.Optional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 16:18
 */
public class CacheLoginUtils {

  private static final TimedCache<String, AccountDO> CACHE_LOGIN = CacheUtil.newTimedCache(1800000);


  public static AccountDO get(String key){
    return CACHE_LOGIN.get(key);
  }

  public static void put(String key, AccountDO accountDO){
    Optional.ofNullable(accountDO).ifPresent(value-> CACHE_LOGIN.put(key, accountDO));
  }


  public static void put(String key, AccountDO accountDO, long expire){
    Optional.ofNullable(accountDO).ifPresent(value-> CACHE_LOGIN.put(key, accountDO, expire));

  }




}

package xyz.sanjiaomao.infrastructure.utils;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import xyz.sanjiaomao.domain.account.AccountAggregate;

import java.util.Optional;

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


  public static AccountAggregate get(String key){
    return CACHE_LOGIN.get(key);
  }

  public static void put(String key, AccountAggregate aggregate){
    Optional.ofNullable(aggregate).ifPresent(value-> CACHE_LOGIN.put(key, aggregate));
  }


  public static void put(String key, AccountAggregate aggregate, long expire){
    Optional.ofNullable(aggregate).ifPresent(value-> CACHE_LOGIN.put(key, aggregate, expire));
  }

  public static void remove(String key){
    CACHE_LOGIN.remove(key);
  }




}

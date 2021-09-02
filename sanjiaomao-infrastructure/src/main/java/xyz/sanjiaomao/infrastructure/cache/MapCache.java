package xyz.sanjiaomao.infrastructure.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-02 22:13
 */
public class MapCache {


  private static final Map<String, Object> CACHE = new ConcurrentHashMap<>();


  @SuppressWarnings("unchecked")
  public static <T> T get(String key){
    return (T)CACHE.get(key);
  }

  public static <T> void set(String key, Object value){
    CACHE.put(key, value);
  }


}

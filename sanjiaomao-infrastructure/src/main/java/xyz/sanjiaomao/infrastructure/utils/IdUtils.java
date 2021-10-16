package xyz.sanjiaomao.infrastructure.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 14:47
 */
public class IdUtils {


  public static class AccountId {
    private static final Snowflake snowflake = IdUtil.getSnowflake(1, 1);
    public static long nextId(){
      return snowflake.nextId();
    }
  }

  public static class UserId {
    private static final Snowflake snowflake = IdUtil.getSnowflake(1, 2);
    public static long nextId(){
      return snowflake.nextId();
    }
  }

  public static class RoleId {
    private static final Snowflake snowflake = IdUtil.getSnowflake(1, 3);
    public static long nextId(){
      return snowflake.nextId();
    }
  }

  public static class AccountRoleId {
    private static final Snowflake snowflake = IdUtil.getSnowflake(1, 4);
    public static long nextId(){
      return snowflake.nextId();
    }
  }

}

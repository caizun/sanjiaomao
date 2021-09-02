package xyz.sanjiaomao.infrastructure.account.entity;

import xyz.sanjiaomao.domain.account.AccountBO;
import xyz.sanjiaomao.domain.account.entity.MyLoginRecord;
import xyz.sanjiaomao.infrastructure.cache.MapCache;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * <pre>
 *  登录记录
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-02 22:02
 */
public class MyLoginRecordImpl implements MyLoginRecord {


  private final HttpServletResponse response;

  public MyLoginRecordImpl(HttpServletResponse response){
    this.response = response;
  }


  @Override
  public void add(AccountBO bo) {
    String token = UUID.randomUUID().toString().replaceAll("-","");
    MapCache.set(token, bo);
    Cookie cookie = new Cookie("token", token);
    response.addCookie(cookie);
  }

}

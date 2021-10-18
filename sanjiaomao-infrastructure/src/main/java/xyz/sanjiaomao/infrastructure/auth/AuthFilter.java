package xyz.sanjiaomao.infrastructure.auth;

import cn.hutool.core.util.IdUtil;
import xyz.sanjiaomao.domain.account.AccountAggregate;
import xyz.sanjiaomao.infrastructure.constants.AccountConstant;
import xyz.sanjiaomao.infrastructure.utils.CacheAccountRecordUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-18 21:59
 */
public class AuthFilter implements Filter {


  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    String requestURI = httpServletRequest.getRequestURI();

    HttpServletResponse httpServletResponse = (HttpServletResponse) response;

    Cookie[] cookies = httpServletRequest.getCookies();
    if (Objects.isNull(cookies) && requestURI.startsWith("/public")) {
      chain.doFilter(request, response);
      return;
    }

    if(Objects.isNull(cookies) ){
      error403(httpServletResponse);
      return;
    }

    String cookieValue = Stream.of(cookies).filter(cookie -> Objects.equals(cookie.getName(), AccountConstant.COOKIE_ACCOUNT))
        .map(Cookie::getValue).findFirst().orElse("");
    AccountAggregate aggregate = CacheAccountRecordUtils.get(cookieValue);

    if(Objects.isNull(aggregate) && requestURI.startsWith("/public")){
      chain.doFilter(request, response);
      return;
    }

    if(Objects.isNull(aggregate)){
      error403(httpServletResponse);
      return;
    }

    String id = IdUtil.simpleUUID();
    aggregate.addRecord(id);
    Cookie cookie = new Cookie(AccountConstant.COOKIE_ACCOUNT, id);
    cookie.setMaxAge(Integer.MAX_VALUE);
    httpServletResponse.addCookie(cookie);

    chain.doFilter(request, response);

  }

  private void error403(HttpServletResponse httpServletResponse) throws IOException {
    PrintWriter writer = httpServletResponse.getWriter();
    writer.write("{\"error\":403}");
  }
}

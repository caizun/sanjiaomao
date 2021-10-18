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
import java.util.Optional;
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
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;

    String requestURI = httpServletRequest.getRequestURI();
    if(requestURI.startsWith("/public")){
      chain.doFilter(request, response);
      return;
    }
    String id = IdUtil.simpleUUID();
    Cookie[] cookies = httpServletRequest.getCookies();
    if(Objects.isNull(cookies)){
      error403(httpServletResponse);
      return;
    }

    Optional<String> optional = Stream.of(cookies).filter(cookie -> Objects.equals(cookie.getName(), AccountConstant.COOKIE_ACCOUNT)).map(Cookie::getValue)
        .findFirst();
    if(!optional.isPresent()){
      error403(httpServletResponse);
      return;
    }

    String cookie = optional.get();
    AccountAggregate aggregate = CacheAccountRecordUtils.get(cookie);

    if(Objects.nonNull(aggregate)){
      httpServletRequest.setAttribute(AccountConstant.COOKIE_ACCOUNT, cookie);
      chain.doFilter(request, response);
      return;
    }


    aggregate = CacheAccountRecordUtils.getRefresh(cookie);


    if(Objects.isNull(aggregate)){
      error403(httpServletResponse);
      return;
    }

    CacheAccountRecordUtils.put(id, aggregate);
    CacheAccountRecordUtils.remove(cookie);
    CacheAccountRecordUtils.putRefresh(id, aggregate);
    httpServletResponse.addCookie(new Cookie(AccountConstant.COOKIE_ACCOUNT, id));
    httpServletRequest.setAttribute(AccountConstant.COOKIE_ACCOUNT, id);
    chain.doFilter(request, response);
  }

  private void error403(HttpServletResponse httpServletResponse) throws IOException {
    PrintWriter writer = httpServletResponse.getWriter();
    writer.write("{\"error\":403}");
  }
}

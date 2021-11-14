package xyz.sanjiaomao.infrastructure.auth;

import cn.hutool.json.JSONUtil;
import xyz.sanjiaomao.infrastructure.account.dataobject.AccountDO;
import xyz.sanjiaomao.infrastructure.constants.AccountConstant;
import xyz.sanjiaomao.infrastructure.message.Message;
import xyz.sanjiaomao.infrastructure.utils.CacheAccountRecordUtils;
import xyz.sanjiaomao.infrastructure.utils.Result;

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
    Cookie[] cookies = httpServletRequest.getCookies();
    if(Objects.isNull(cookies)){
      error403(httpServletResponse);
      return;
    }

    Optional<String> optional = Stream.of(cookies).filter(cookie -> Objects.equals(cookie.getName(), AccountConstant.COOKIE_ACCOUNT)).map(Cookie::getValue)
        .findFirst();
    if (!optional.isPresent()) {
      error403(httpServletResponse);
      return;
    }

    AccountDO accountDO = CacheAccountRecordUtils.get(optional.get());
    if (Objects.isNull(accountDO)) {
      error403(httpServletResponse);
      return;
    }

    chain.doFilter(request, response);


  }

  private void error403(HttpServletResponse httpServletResponse) throws IOException {
    PrintWriter writer = httpServletResponse.getWriter();
    int code = 403;
    httpServletResponse.setStatus(code);
    Result<String> result = Result.error(code, Message.NO_AUTHENTICATION);
    writer.write(JSONUtil.toJsonStr(result));
  }
}

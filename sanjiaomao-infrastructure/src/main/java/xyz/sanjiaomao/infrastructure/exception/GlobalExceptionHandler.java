package xyz.sanjiaomao.infrastructure.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.sanjiaomao.infrastructure.utils.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-14 21:10
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  @Resource
  public HttpServletResponse response;

  @ExceptionHandler(Exception.class)
  public Result<String> exception(Exception e) {
    response.setStatus(500);
    return Result.error(e.getMessage());
  }


}

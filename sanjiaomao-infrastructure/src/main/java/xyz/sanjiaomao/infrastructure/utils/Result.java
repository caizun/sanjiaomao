package xyz.sanjiaomao.infrastructure.utils;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-14 20:51
 */
@Data
public class Result<R> {

  int code;

  R r;

  private Result(int code, R r) {
    this.code = code;
    this.r = r;
  }

  public static Result<String> error(String message) {
    return new Result<>(500, message);
  }

  public static Result<String> error(int code, String message) {
    return new Result<>(500, message);
  }


  public static <R> Result<R> successful(R r) {
    return new Result<>(200, r);
  }

}

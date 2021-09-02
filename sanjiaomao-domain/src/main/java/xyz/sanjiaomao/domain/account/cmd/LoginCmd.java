package xyz.sanjiaomao.domain.account.cmd;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <pre>
 *  登录cmd
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-01 00:03
 */
@Data
public class LoginCmd {
  /**
   * 账号名称
   */
  @NotNull(message = "账号不能为空")
  @Size(min = 1, max = 20, message = "账号长度不能超过20字符")
  private String account;
  /**
   * 密码
   */
  @NotNull(message = "密码不能为空")
  @Size(min = 1, max = 20, message = "账号长度不能超过20字符")
  private String password;
}

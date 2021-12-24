package xyz.sanjiaomao.application.account.cmd;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-12-23 01:06
 */
@Data
public class RegistryCmd {
  /**
   * 账号名称
   */
  @NotNull(message = "账号为空")
  @Size(max = 20, message = "账号长度超过限制")
  private String accountName;
  /**
   * 密码
   */
  @NotNull( message = "密码为空")
  @Size(max = 20, message = "密码长度超过限制")
  private String password;
  /**
   * 账号别名
   */
  @NotNull(message = "昵称为空")
  @Size(max = 20, message = "昵称长度超过限制")
  private String nickname;
}

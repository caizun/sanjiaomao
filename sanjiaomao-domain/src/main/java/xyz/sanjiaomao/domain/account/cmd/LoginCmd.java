package xyz.sanjiaomao.domain.account.cmd;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 17:29
 */
@Data
public class LoginCmd {
  /**
   * 账号名称
   */
  @NotNull(message = "账号名称不能为空")
  @Size(min = 6, max = 20, message = "密码长度不在6-20之间")
  private String account;
  /**
   * 密码
   */
  @NotNull(message = "密码不能为空")
  @Size(min = 6, max = 20, message = "密码长度不在6-20之间")
  private String password;

}

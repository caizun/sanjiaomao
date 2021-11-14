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
 * create by 2021-10-16 16:25
 */
@Data
public class CreateAccountCmd {
  /**
   * 账号名称
   */
  @NotNull(message = "账号名称不能为空")
  @Size(min = 6, max = 20)
  private String accountName;
  /**
   * 密码
   */
  @NotNull(message = "密码不能为空")
  @Size(min = 6, max = 20)
  private String password;
  /**
   * 重复密码
   */
  @NotNull(message="确认密码不能为空")
  @Size(min=6, max=20)
  private String rePassword;
  /**
   * 别名
   */
  @NotNull(message="别名不能为空")
  @Size(min=6, max=20)
  private String nickname;
}

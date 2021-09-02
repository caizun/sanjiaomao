package xyz.sanjiaomao.domain.account.cmd;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <pre>
 *  创建账号cmd
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-08-31 23:17
 */
@Data
public class CreateAccountCmd {
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
  @Size(min = 1, max = 20, message = "密码长度不能超过20字符")
  private String password;
  /**
   * 重复密码
   */
  @NotNull(message = "重复密码不能为空")
  @Size(min = 1, max = 20, message = "重复密码长度不能超过20字符")
  private String rePassword;
  /**
   * 名称
   */
  @NotNull(message = "名称不能为空")
  @Size(min = 1, max = 20, message = "名称长度不能超过20字符")
  private String nickname;

}

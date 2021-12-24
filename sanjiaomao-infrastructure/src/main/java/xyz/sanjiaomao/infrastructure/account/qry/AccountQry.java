package xyz.sanjiaomao.infrastructure.account.qry;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-12-23 00:57
 */
@Data
public class AccountQry {
  /**
   * 账号名称
   */
  @NotNull(groups = {AccountQryGroup.LoginGroup.class}, message = "账号为空")
  @Size(max = 20, message = "账号长度超过限制")
  private String accountName;
  /**
   * 密码
   */
  @NotNull(groups = {AccountQryGroup.LoginGroup.class}, message = "密码为空")
  @Size(max = 20, message = "密码长度超过限制")
  private String password;
  /**
   * 账号别名
   */
  @Size(max = 20, message = "昵称长度超过限制")
  private String nickname;

}

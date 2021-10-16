package xyz.sanjiaomao.domain.account.cmd;

import lombok.Data;

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
  private String account;
  /**
   * 密码
   */
  private String password;
  /**
   * 重复密码
   */
  private String rePassword;
  /**
   * 别名
   */
  private String nickname;
}

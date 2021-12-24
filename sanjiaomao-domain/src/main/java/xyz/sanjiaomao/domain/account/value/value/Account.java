package xyz.sanjiaomao.domain.account.value.value;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-12-23 00:40
 */
@Getter
@EqualsAndHashCode
public class Account {
  /**
   * 账号
   */
  private final String accountName;
  /**
   * 密码
   */
  private final String password;
  /**
   * 账号别名
   */
  private final String nickname;


  public Account(String accountName, String password, String nickname) {
    this.accountName = accountName;
    this.password = password;
    this.nickname = nickname;
  }
}

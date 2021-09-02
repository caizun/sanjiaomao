package xyz.sanjiaomao.domain.account.val;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <pre>
 *  账号值对象
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-01 00:37
 */
@Data
@AllArgsConstructor
public class AccountDO {
  /**
   * 账号
   */
  private String account;
  /**
   * 密码
   */
  private String password;
  /**
   * 名称
   */
  private String nickname;

}

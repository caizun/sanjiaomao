package xyz.sanjiaomao.domain.account.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 14:35
 */
@Getter
@AllArgsConstructor
public class Account {

  private final String accountName;

  private final String password;

  private final String nickname;
}

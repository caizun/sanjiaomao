package xyz.sanjiaomao.domain.account;

import xyz.sanjiaomao.domain.account.entity.PersonEntity;
import xyz.sanjiaomao.domain.account.value.value.Account;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-12-23 00:33
 */
public class AccountAggregate {
  /**
   * id
   */
  private Long id;
  /**
   * 账号
   */
  private Account account;
  /**
   * 人
   */
  private PersonEntity personEntity;


  public AccountAggregate(Long id){
      this.id = id;
  }

  /**
   * 创建账号
   * @param accountName 账号名称
   * @param password 密码
   * @param nickname 账号别名
   */
  public void create(String accountName, String password, String nickname) {
    this.account = new Account(accountName,password,nickname);
  }
  /**
   * 账号关联人
   * @param personEntity {@link PersonEntity}
   */
  public void relPerson(PersonEntity personEntity) {
    this.personEntity = personEntity;
  }

}

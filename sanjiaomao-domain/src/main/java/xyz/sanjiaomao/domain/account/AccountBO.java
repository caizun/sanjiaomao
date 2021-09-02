package xyz.sanjiaomao.domain.account;

import lombok.Data;
import xyz.sanjiaomao.domain.account.cmd.CreateAccountCmd;
import xyz.sanjiaomao.domain.account.cmd.LoginCmd;
import xyz.sanjiaomao.domain.account.entity.MyLoginRecord;
import xyz.sanjiaomao.domain.account.entity.OwnerSysUser;
import xyz.sanjiaomao.domain.account.val.AccountDO;

import java.util.Objects;

/**
 * <pre>
 *  账号聚合根
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-01 00:35
 */
@Data
public class AccountBO {

  /**
   * 聚合根主键
   */
  private final Long id;
  /**
   * 账号值对象
   */
  private AccountDO accountDO;
  /**
   * 账号归属人
   */
  private OwnerSysUser ownerSysUser;
  /**
   * 登录记录
   */
  private MyLoginRecord myLoginRecord;

  public AccountBO(Long id, AccountDO accountDO) {
    this.id = id;
    this.accountDO = accountDO;
  }

  public boolean exist() {
    return Objects.isNull(id);
  }

  public void create(CreateAccountCmd cmd) {
    this.accountDO = new AccountDO(cmd.getAccount(), cmd.getPassword(), cmd.getNickname());
  }

  public boolean checkPassword(LoginCmd cmd) {
    return Objects.equals(cmd.getPassword(), accountDO.getPassword());
  }

  public void addLoginRecord() {
    myLoginRecord.add(this);
  }
}

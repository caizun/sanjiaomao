package xyz.sanjiaomao.domain.account;

import lombok.Data;
import xyz.sanjiaomao.domain.account.entity.AccountOwnerEntity;
import xyz.sanjiaomao.domain.account.entity.MyRecordEntity;
import xyz.sanjiaomao.domain.account.entity.MyRoleEntity;
import xyz.sanjiaomao.domain.account.valueobject.Account;

/**
 * <pre>
 *  账号
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 14:35
 */
@Data
public class AccountAggregate {
  /**
   * 主键
   */
  private final Long id;
  /**
   * 账号值对象
   */
  private Account account;
  /**
   * 账号归属人
   */
  private AccountOwnerEntity accountOwnerEntity;
  /**
   * 账号的角色
   */
  private MyRoleEntity myRoleEntity;
  /**
   *
   */
  private MyRecordEntity myRecordEntity;


  public AccountAggregate(Long id){
    this.id = id;
  }

  /**
   * 添加角色
   * @param roleId 角色id
   */
  public void addRole(Long roleId) {
    myRoleEntity.addRole(this.id, roleId);
  }


  public void addRecord(String recordId) {
    myRecordEntity.addRecord(recordId, this);
  }

  public void delRecord(String recordId) {
    myRecordEntity.delRecord(recordId);
  }
}

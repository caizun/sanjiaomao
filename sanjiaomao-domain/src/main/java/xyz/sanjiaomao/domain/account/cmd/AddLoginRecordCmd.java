package xyz.sanjiaomao.domain.account.cmd;
import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 17:29
 */
@Data
public class AddLoginRecordCmd {
  /**
   * 账号名称
   */
  private String account;
  /**
   * 密码
   */
  private String password;

}

package xyz.sanjiaomao.application.account;

import cn.hutool.core.lang.Assert;
import org.springframework.stereotype.Service;
import xyz.sanjiaomao.domain.account.AccountBO;
import xyz.sanjiaomao.domain.account.cmd.CreateAccountCmd;
import xyz.sanjiaomao.domain.account.cmd.LoginCmd;
import xyz.sanjiaomao.domain.account.repository.AccountRepository;

import javax.annotation.Resource;

/**
 * <pre>
 *  账号service
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-02 20:55
 */
@Service
public class AccountService {

  @Resource
  private AccountRepository accountRepository;

  /**
   *
   * @param cmd {@link CreateAccountCmd}
   * @return info
   */
  public String create(CreateAccountCmd cmd) {
    //加载account
    AccountBO accountBO = accountRepository.findByAccount(cmd.getAccount());
    Assert.isTrue(accountBO.exist(), "账号已存在");
    accountBO.create(cmd);
    accountRepository.create(accountBO);
    return "注册成功";
  }

  /**
   * 登录
   * @param cmd {@link LoginCmd}
   * @return info
   */
  public String login(LoginCmd cmd) {
    AccountBO accountBO = accountRepository.findByAccount(cmd.getAccount());
    Assert.isFalse(accountBO.exist(), "账号不存在");
    Assert.isTrue(accountBO.checkPassword(cmd), "密码错误");
    accountBO.addLoginRecord();
    return "登录成功";
  }


}

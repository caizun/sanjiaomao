package xyz.sanjiaomao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.sanjiaomao.Application;
import xyz.sanjiaomao.api.account.AccountController;
import xyz.sanjiaomao.domain.account.cmd.CreateAccountCmd;
import xyz.sanjiaomao.domain.account.cmd.LoginCmd;

import javax.annotation.Resource;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-02 21:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class AccountTast {


  @Resource
  private AccountController accountController;


  @Test
  public void createAccountTest() {
    //参数
    CreateAccountCmd cmd = new CreateAccountCmd();
    cmd.setAccount("admin");
    cmd.setPassword("admin");
    cmd.setRePassword("admin");
    cmd.setNickname("admin");
    accountController.create(cmd);
  }

  @Test
  public void login(){
    LoginCmd cmd = new LoginCmd();
    cmd.setAccount("admin");
    cmd.setPassword("admin");
    accountController.login(cmd);
  }
}

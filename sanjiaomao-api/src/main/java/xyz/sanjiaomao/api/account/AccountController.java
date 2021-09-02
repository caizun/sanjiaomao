package xyz.sanjiaomao.api.account;

import cn.hutool.core.lang.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.sanjiaomao.application.account.AccountService;
import xyz.sanjiaomao.domain.account.cmd.CreateAccountCmd;
import xyz.sanjiaomao.domain.account.cmd.LoginCmd;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <pre>
 *  controller
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-02 21:17
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {


  @Resource
  private AccountService accountService;


  @PostMapping
  public String create(@Validated @RequestBody CreateAccountCmd cmd) {
    Assert.isTrue(Objects.equals(cmd.getPassword(), cmd.getRePassword()), "两次输入密码不一致");
    return accountService.create(cmd);
  }


  @PutMapping("/record")
  public String login(@Validated @RequestBody LoginCmd cmd){
    return accountService.login(cmd);
  }


}

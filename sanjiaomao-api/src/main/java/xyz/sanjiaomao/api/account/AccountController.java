package xyz.sanjiaomao.api.account;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.sanjiaomao.application.account.AccountOptService;
import xyz.sanjiaomao.domain.account.cmd.CreateAccountCmd;
import xyz.sanjiaomao.domain.account.cmd.LoginCmd;

import javax.annotation.Resource;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-17 00:54
 */
@RestController
@RequestMapping("/public/account")
public class AccountController {

  @Resource
  private AccountOptService accountOptService;

  @PostMapping
  public void registry(@Validated @RequestBody CreateAccountCmd cmd) {
    accountOptService.registry(cmd);
  }


  @GetMapping
  public void login(@Validated LoginCmd cmd) {
    accountOptService.login(cmd);
  }


}

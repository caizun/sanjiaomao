package xyz.sanjiaomao.api.account;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.application.account.AccountOptService;
import xyz.sanjiaomao.domain.account.cmd.AddRecordCmd;
import xyz.sanjiaomao.domain.account.cmd.CreateAccountCmd;

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
  public void registry(@Validated @RequestBody CreateAccountCmd cmd){
    accountOptService.registry(cmd);
  }


  @PostMapping("/record")
  public void login(@Validated @RequestBody AddRecordCmd cmd){
    accountOptService.login(cmd);
  }


}

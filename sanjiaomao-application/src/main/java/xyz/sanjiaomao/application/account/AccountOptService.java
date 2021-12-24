package xyz.sanjiaomao.application.account;

import org.springframework.stereotype.Service;
import xyz.sanjiaomao.application.account.cmd.RegistryCmd;
import xyz.sanjiaomao.domain.account.AccountAggregate;
import xyz.sanjiaomao.domain.account.repository.AccountRepository;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-12-23 01:08
 */
@Service
public class AccountOptService {


  private AccountRepository accountRepository;


  public void registry(RegistryCmd cmd) {
    AccountAggregate aggregate = new AccountAggregate(1L);
    aggregate.create(cmd.getAccountName(), cmd.getPassword(), cmd.getNickname());
    accountRepository.save(aggregate);
  }
}

package xyz.sanjiaomao.infrastructure.account.repository;

import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.domain.account.AccountAggregate;
import xyz.sanjiaomao.domain.account.cmd.CreateAccountCmd;
import xyz.sanjiaomao.domain.account.repository.AccountRepository;
import xyz.sanjiaomao.domain.account.valueobject.Account;
import xyz.sanjiaomao.infrastructure.account.dataobject.AccountDO;
import xyz.sanjiaomao.infrastructure.account.entity.AccountOwnerEntityImpl;
import xyz.sanjiaomao.infrastructure.account.entity.MyRoleEntityImpl;
import xyz.sanjiaomao.infrastructure.mapper.AccountMapper;
import xyz.sanjiaomao.infrastructure.mapper.AccountRoleRelMapper;
import xyz.sanjiaomao.infrastructure.mapper.RoleMapper;
import xyz.sanjiaomao.infrastructure.mapper.UserMapper;
import xyz.sanjiaomao.infrastructure.utils.IdUtils;

import javax.annotation.Resource;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 17:15
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

  @Resource
  private AccountMapper accountMapper;

  @Resource
  private AccountRoleRelMapper accountRoleRelMapper;

  @Resource
  private RoleMapper roleMapper;

  @Resource
  private UserMapper userMapper;

  @Override
  public AccountAggregate create(CreateAccountCmd cmd) {
    AccountAggregate aggregate = new AccountAggregate(IdUtils.AccountId.nextId());
    Account account = new Account(cmd.getAccount(), cmd.getPassword(), cmd.getNickname());
    aggregate.setAccount(account);
    aggregate.setAccountOwnerEntity(new AccountOwnerEntityImpl(userMapper));
    aggregate.setMyRoleEntity(new MyRoleEntityImpl(roleMapper, accountRoleRelMapper));
    return aggregate;
  }

  @Override
  public void save(AccountAggregate aggregate) {
    Account account = aggregate.getAccount();
    AccountDO accountDO = new AccountDO();
    accountDO.setId(aggregate.getId());
    accountDO.setAccount(account.getAccount());
    accountDO.setPassword(account.getPassword());
    accountDO.setNickname(account.getNickname());
    accountMapper.insert(accountDO);
  }

  @Override
  public AccountAggregate findById(Long id) {
    AccountDO accountDO = accountMapper.selectByPrimaryKey(id);
    AccountAggregate aggregate = new AccountAggregate(accountDO.getId());
    Account account = new Account(accountDO.getAccount(), accountDO.getPassword(), accountDO.getNickname());
    aggregate.setAccount(account);
    aggregate.setAccountOwnerEntity(new AccountOwnerEntityImpl(userMapper));
    aggregate.setMyRoleEntity(new MyRoleEntityImpl(roleMapper, accountRoleRelMapper));
    return aggregate;
  }
}

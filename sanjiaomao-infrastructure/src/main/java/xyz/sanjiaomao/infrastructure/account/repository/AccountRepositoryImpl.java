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
    return build(IdUtils.AccountId.nextId(), cmd.getAccount(), cmd.getPassword(), cmd.getNickname());
  }

  @Override
  public AccountAggregate findById(Long id) {
    AccountDO accountDO = accountMapper.selectByPrimaryKey(id);
    return build(accountDO.getId(), accountDO.getAccount(), accountDO.getPassword(), accountDO.getNickname());
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




  private AccountAggregate build(Long id, String account, String password, String nickname){
    AccountAggregate aggregate = new AccountAggregate(id);
    aggregate.setAccount(new Account(account, password, nickname));
    aggregate.setAccountOwnerEntity(new AccountOwnerEntityImpl(userMapper));
    aggregate.setMyRoleEntity(new MyRoleEntityImpl(roleMapper, accountRoleRelMapper));
    return aggregate;
  }

}

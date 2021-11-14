package xyz.sanjiaomao.application.account;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import xyz.sanjiaomao.infrastructure.account.dataobject.AccountDO;
import xyz.sanjiaomao.infrastructure.account.qry.AccountQry;
import xyz.sanjiaomao.infrastructure.mapper.AccountMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-16 16:14
 */
@Service
public class AccountQryService {

  @Resource
  private AccountMapper accountMapper;

  public AccountDO selectByAccount(String account) {
    AccountQry qry = new AccountQry();
    qry.setAccountName(account);
    List<AccountDO> listAccount = select(qry);
    return CollectionUtils.isEmpty(listAccount) ? new AccountDO() : listAccount.get(0);

  }


  public List<AccountDO> select(AccountQry qry) {
    return accountMapper.select(qry);
  }
}

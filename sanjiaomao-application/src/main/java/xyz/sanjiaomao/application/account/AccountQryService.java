package xyz.sanjiaomao.application.account;

import org.springframework.stereotype.Service;
import xyz.sanjiaomao.infrastructure.account.qry.AccountQry;
import xyz.sanjiaomao.infrastructure.mapper.AccountMapper;
import xyz.sanjiaomao.infrastructure.plant.dataobject.AccountDO;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-12-23 01:13
 */
@Service
public class AccountQryService {

  @Resource
  private AccountMapper accountMapper;

  public Boolean login(AccountQry qry) {
    AccountDO accountDO = accountMapper.selectByAccountName(qry);
    if(!Objects.equals(accountDO.getPassword(), qry.getPassword())) {
       return false;
    }
    //就放缓存
    return true;
  }

}

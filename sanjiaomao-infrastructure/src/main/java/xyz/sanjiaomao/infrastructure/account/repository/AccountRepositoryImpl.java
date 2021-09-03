package xyz.sanjiaomao.infrastructure.account.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.sanjiaomao.domain.account.AccountBO;
import xyz.sanjiaomao.domain.account.repository.AccountRepository;
import xyz.sanjiaomao.domain.account.val.AccountDO;
import xyz.sanjiaomao.infrastructure.account.dao.AccountDAO;
import xyz.sanjiaomao.infrastructure.account.entity.MyRecordImpl;
import xyz.sanjiaomao.infrastructure.account.entity.OwnerSysUserImpl;
import xyz.sanjiaomao.infrastructure.mapper.AccountDAOMapper;
import xyz.sanjiaomao.infrastructure.mapper.SysUserDAOMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * <pre>
 *  仓储
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-02 20:52
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

  @Resource
  private AccountDAOMapper accountDAOMapper;

  @Resource
  private SysUserDAOMapper sysUserDAOMapper;

  private final HttpServletResponse httpServletResponse;

  @Autowired(required = false)
  public AccountRepositoryImpl( HttpServletResponse httpServletResponse){
    this.httpServletResponse = httpServletResponse;
  }


  @Override
  public AccountBO findByAccount(String account) {

    AccountDAO accountDAO = accountDAOMapper.findByAccount(account);
    if (Objects.isNull(accountDAO)) {
      return new AccountBO(null, null);
    }
    AccountBO accountBO = new AccountBO(accountDAO.getId(),
        new AccountDO(accountDAO.getAccount(), accountDAO.getPassword(), accountDAO.getNickname()));
    accountBO.setOwnerSysUser(new OwnerSysUserImpl(sysUserDAOMapper));
    accountBO.setMyRecord(new MyRecordImpl(httpServletResponse));
    return accountBO;
  }

  @Override
  public void create(AccountBO accountBO) {
    AccountDAO accountDAO = new AccountDAO();
    accountDAO.setId(accountBO.getId());
    AccountDO accountDO = accountBO.getAccountDO();
    accountDAO.setAccount(accountDO.getAccount());
    accountDAO.setPassword(accountDO.getPassword());
    accountDAO.setNickname(accountDO.getNickname());
    accountDAOMapper.insert(accountDAO);
    accountBO.setId(accountDAO.getId());
  }
}

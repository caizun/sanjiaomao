package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.account.qry.AccountQry;
import xyz.sanjiaomao.infrastructure.plant.dataobject.AccountDO;

import java.util.List;

public interface AccountMapper {
  int deleteByPrimaryKey(Long id);

  int insert(AccountDO record);

  AccountDO selectByPrimaryKey(Long id);

  List<AccountDO> selectAll();

  int updateByPrimaryKey(AccountDO record);

  AccountDO selectByAccountName(AccountQry qry);
}
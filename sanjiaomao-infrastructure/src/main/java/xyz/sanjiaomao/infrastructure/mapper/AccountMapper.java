package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.account.dataobject.AccountDO;
import xyz.sanjiaomao.infrastructure.account.qry.AccountQry;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountDO record);

    AccountDO selectByPrimaryKey(Long id);

    List<AccountDO> select(AccountQry qry);

    int updateByPrimaryKey(AccountDO record);
}
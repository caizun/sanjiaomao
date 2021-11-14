package xyz.sanjiaomao.infrastructure.mapper;

import org.apache.ibatis.annotations.Param;
import xyz.sanjiaomao.infrastructure.account.dataobject.AccountRoleRelDO;

import java.util.List;

public interface AccountRoleRelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountRoleRelDO record);

    AccountRoleRelDO selectByPrimaryKey(Long id);

  List<AccountRoleRelDO> selectByAccountId(@Param("accountId") Long accountId);

    int updateByPrimaryKey(AccountRoleRelDO record);
}
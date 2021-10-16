package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.account.dataobject.AccountRoleRelDO;

import java.util.List;

public interface AccountRoleRelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountRoleRelDO record);

    AccountRoleRelDO selectByPrimaryKey(Long id);

    List<AccountRoleRelDO> selectAll();

    int updateByPrimaryKey(AccountRoleRelDO record);
}
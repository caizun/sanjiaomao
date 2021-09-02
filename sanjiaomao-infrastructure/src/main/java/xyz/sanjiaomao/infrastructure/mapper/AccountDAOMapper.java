package xyz.sanjiaomao.infrastructure.mapper;

import java.util.List;
import xyz.sanjiaomao.infrastructure.account.dao.AccountDAO;

public interface AccountDAOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountDAO record);

    AccountDAO selectByPrimaryKey(Long id);

    List<AccountDAO> selectAll();

    int updateByPrimaryKey(AccountDAO record);

    AccountDAO findByAccount(String account);
}
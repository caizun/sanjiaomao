package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.plant.dataobject.Account;

import java.util.List;

public interface AccountMapper {
  int deleteByPrimaryKey(Long id);

  int insert(Account record);

  Account selectByPrimaryKey(Long id);

  List<Account> selectAll();

  int updateByPrimaryKey(Account record);
}
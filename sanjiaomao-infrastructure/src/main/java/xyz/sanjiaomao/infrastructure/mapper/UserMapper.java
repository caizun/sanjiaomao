package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.account.dataobject.UserDO;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String user);

    int insert(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    List<UserDO> selectAll();

    int updateByPrimaryKey(UserDO record);
}
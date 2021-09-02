package xyz.sanjiaomao.infrastructure.mapper;

import java.util.List;
import xyz.sanjiaomao.infrastructure.account.dao.SysUserDAO;

public interface SysUserDAOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserDAO record);

    SysUserDAO selectByPrimaryKey(Long id);

    List<SysUserDAO> selectAll();

    int updateByPrimaryKey(SysUserDAO record);
}
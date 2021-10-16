package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.account.dataobject.RoleDO;
import xyz.sanjiaomao.infrastructure.account.qry.RoleQry;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleDO record);

    RoleDO selectByPrimaryKey(Long id);

    List<RoleDO> select(RoleQry qry);

    int updateByPrimaryKey(RoleDO record);
}
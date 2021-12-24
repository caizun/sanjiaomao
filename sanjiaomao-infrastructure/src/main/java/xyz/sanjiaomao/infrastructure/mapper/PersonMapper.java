package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.plant.dataobject.PersonDO;

import java.util.List;

public interface PersonMapper {
  int deleteByPrimaryKey(Long id);

  int insert(PersonDO record);

  PersonDO selectByPrimaryKey(Long id);

  List<PersonDO> selectAll();

  int updateByPrimaryKey(PersonDO record);
}
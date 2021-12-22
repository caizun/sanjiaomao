package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.plant.dataobject.Person;

import java.util.List;

public interface PersonMapper {
  int deleteByPrimaryKey(Long id);

  int insert(Person record);

  Person selectByPrimaryKey(Long id);

  List<Person> selectAll();

  int updateByPrimaryKey(Person record);
}
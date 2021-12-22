package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.plant.dataobject.Plant;

import java.util.List;

public interface PlantMapper {
  int deleteByPrimaryKey(Long id);

  int insert(Plant record);

  Plant selectByPrimaryKey(Long id);

  List<Plant> selectAll();

  int updateByPrimaryKey(Plant record);
}
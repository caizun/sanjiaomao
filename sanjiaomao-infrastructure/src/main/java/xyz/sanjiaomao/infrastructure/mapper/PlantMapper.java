package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.plant.dataobject.PlantDO;

import java.util.List;

public interface PlantMapper {
  int insert(PlantDO record);

  List<PlantDO> selectAll();
}
package xyz.sanjiaomao.infrastructure.mapper;

import xyz.sanjiaomao.infrastructure.plant.dataobject.PlantDO;

import java.util.List;

public interface PlantMapper {
  int deleteByPrimaryKey(Long id);

  int insert(PlantDO record);

  PlantDO selectByPrimaryKey(Long id);

  List<PlantDO> selectAll();

  int updateByPrimaryKey(PlantDO record);
}
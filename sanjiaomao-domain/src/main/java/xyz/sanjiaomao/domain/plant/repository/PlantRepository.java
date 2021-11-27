package xyz.sanjiaomao.domain.plant.repository;

import xyz.sanjiaomao.domain.plant.PlantAggregate;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-27 17:18
 */
public interface PlantRepository {


  void save(PlantAggregate plantAggregate);

  PlantAggregate findById(Long id);
}

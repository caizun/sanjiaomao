package xyz.sanjiaomao.infrastructure.plant.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.sanjiaomao.domain.plant.PlantAggregate;
import xyz.sanjiaomao.domain.plant.repository.PlantRepository;
import xyz.sanjiaomao.infrastructure.mapper.PlantMapper;
import xyz.sanjiaomao.infrastructure.plant.dataobject.PlantDO;

import javax.annotation.Resource;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-27 21:25
 */
@Repository
public class PlantRepositoryImpl implements PlantRepository {

  @Resource
  private PlantMapper plantMapper;


  @Override
  @Transactional
  public void save(PlantAggregate aggregate) {
    PlantDO plantDO = new PlantDO();
    plantDO.setId(aggregate.getId());
    plantDO.setPlantName(aggregate.getPlantName());
    plantDO.setPlantDate(aggregate.getPlantDate());
    String plantContent = aggregate.getPlantContent();
    plantDO.setPlantKey(plantContent.length() < 20 ? plantContent : plantContent.substring(0, 20));
    plantDO.setPlantContent(plantContent);
    plantDO.setAccountId(aggregate.getAccountId());
    plantMapper.insert(plantDO);
  }

  @Override
  public PlantAggregate findById(Long id) {
    return null;
  }
}

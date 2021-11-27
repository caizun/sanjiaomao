package xyz.sanjiaomao.application.plant;

import org.springframework.stereotype.Service;
import xyz.sanjiaomao.domain.plant.PlantAggregate;
import xyz.sanjiaomao.domain.plant.cmd.CreatePlantCmd;
import xyz.sanjiaomao.domain.plant.cmd.CreateRecordCmd;
import xyz.sanjiaomao.domain.plant.repository.PlantRepository;
import xyz.sanjiaomao.infrastructure.utils.IdUtils;

import javax.annotation.Resource;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-27 17:10
 */
@Service
public class PlantOptService {

  @Resource
  private PlantRepository plantRepository;

  public void createPlant(Long accountId, CreatePlantCmd cmd) {
    PlantAggregate plantAggregate = new PlantAggregate(IdUtils.PlantId.nextId());
    plantAggregate.create(accountId, cmd);
    plantRepository.save(plantAggregate);
  }

  public void createRecord(Long plantId, CreateRecordCmd cmd) {
    PlantAggregate aggregate = plantRepository.findById(plantId);
    aggregate.addRecord(cmd);
  }
}
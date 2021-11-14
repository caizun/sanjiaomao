package xyz.sanjiaomao.domain.plant.entity;

import xyz.sanjiaomao.domain.plant.PlantAggregate;
import xyz.sanjiaomao.domain.plant.cmd.CreateRecordCmd;

/**
 * <pre>
 * 打卡记录
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-14 23:31
 */
public interface PlantRecord {
  void create(PlantAggregate plantAggregate, CreateRecordCmd cmd);

  void delete(Long commentId);
}

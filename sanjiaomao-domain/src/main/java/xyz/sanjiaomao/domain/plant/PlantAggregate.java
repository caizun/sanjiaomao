package xyz.sanjiaomao.domain.plant;

import lombok.Data;
import xyz.sanjiaomao.domain.plant.entity.PlantComment;
import xyz.sanjiaomao.domain.plant.entity.PlantRecord;

/**
 * <pre>
 *  计划聚合根
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-14 23:27
 */
@Data
public class PlantAggregate {
  /**
   * 主键
   */
  private Long id;
  /**
   * 计划内容
   */
  private String plantContent;
  /**
   * 打卡记录
   */
  private PlantRecord plantRecord;
  /**
   * 计划评论
   */
  private PlantComment plantComment;
  /**
   * 账号id
   */
  private Long accountId;


}

package xyz.sanjiaomao.domain.plant.cmd;

import lombok.Data;

import java.util.Date;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-27 17:23
 */
@Data
public class CreatePlantCmd {
  /**
   * 计划名称
   */
  private String name;
  /**
   * 开始时间
   */
  private Date plantDate;
  /**
   * 计划内容
   */
  private String plantContent;
}

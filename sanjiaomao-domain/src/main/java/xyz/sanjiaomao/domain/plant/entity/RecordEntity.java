package xyz.sanjiaomao.domain.plant.entity;

import lombok.Data;

import java.util.Date;

/**
 * <pre>
 * 记录实体
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-14 23:31
 */
@Data
public class RecordEntity {
  /**
   * 主键
   */
  private Long id;
  /**
   * 日期
   */
  private Date date;
  /**
   * 备注
   */
  private String remark;


}
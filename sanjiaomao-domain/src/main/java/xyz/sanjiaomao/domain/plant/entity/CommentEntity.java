package xyz.sanjiaomao.domain.plant.entity;

import lombok.Data;

import java.util.Date;

/**
 * <pre>
 *  评论实体
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-14 23:31
 */
@Data
public class CommentEntity {
  /**
   * 主键
   */
  private Long id;
  /**
   * 日期
   */
  private Date contentDate;
  /**
   * 内容
   */
  private String content;
  /**
   * 评论用户
   */
  private Long accountId;

}

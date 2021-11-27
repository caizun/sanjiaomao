package xyz.sanjiaomao.domain.plant;

import lombok.Data;
import xyz.sanjiaomao.domain.plant.cmd.CreateCommentCmd;
import xyz.sanjiaomao.domain.plant.cmd.CreatePlantCmd;
import xyz.sanjiaomao.domain.plant.cmd.CreateRecordCmd;
import xyz.sanjiaomao.domain.plant.entity.PlantComment;
import xyz.sanjiaomao.domain.plant.entity.PlantRecord;

import java.util.Date;

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
   * 计划名称
   */
  private String plantName;
  /**
   * 计划时间
   */
  private Date plantDate;
  /**
   * 计划内容
   */
  private String plantContent;
  /**
   * 浏览
   */
  private Long browse;
  /**
   * 点赞
   */
  private Long fabulous;
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

  public PlantAggregate(Long id) {
    this.id = id;
  }

  public void addRecord(CreateRecordCmd cmd) {
    plantRecord.create(this, cmd);
  }


  public void addComment(CreateCommentCmd cmd) {
    plantComment.create(this, cmd);
  }

  public void deletedComment(Long commentId) {
    plantRecord.delete(commentId);
  }

  public void browse() {
    browse++;
  }

  public void fabulous() {
    fabulous++;
  }


  public void create(Long accountId, CreatePlantCmd cmd) {
    this.accountId = accountId;
    this.plantName = cmd.getPlantName();
    this.plantDate = cmd.getPlantDate();
    this.plantContent = cmd.getPlantContent();
  }
}

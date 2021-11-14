package xyz.sanjiaomao.domain.plant.entity;

import xyz.sanjiaomao.domain.plant.PlantAggregate;
import xyz.sanjiaomao.domain.plant.cmd.CreateCommentCmd;

/**
 * <pre>
 *  计划评论
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-14 23:31
 */

public interface PlantComment {
  void create(PlantAggregate plantAggregate, CreateCommentCmd cmd);
}

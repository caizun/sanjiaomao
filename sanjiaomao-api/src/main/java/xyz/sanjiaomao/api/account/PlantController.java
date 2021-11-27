package xyz.sanjiaomao.api.account;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.sanjiaomao.application.plant.PlantOptService;
import xyz.sanjiaomao.domain.plant.cmd.CreatePlantCmd;
import xyz.sanjiaomao.infrastructure.constants.AccountConstant;
import xyz.sanjiaomao.infrastructure.utils.Result;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-27 17:06
 */
@RequestMapping("/plant")
@RestController
public class PlantController {

  @Resource
  private HttpServletRequest httpServletRequest;
  @Resource
  private PlantOptService plantOptService;

  @PostMapping
  public Result<Boolean> plant(CreatePlantCmd cmd) {
    Long accountId = ((Long) httpServletRequest.getAttribute(AccountConstant.ID));
    plantOptService.createPlant(accountId, cmd);
    return Result.successful(Boolean.TRUE);
  }

}

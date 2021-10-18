package xyz.sanjiaomao.api.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-18 22:43
 */
@RestController
@RequestMapping("/console")
public class ConsoleController {


  @GetMapping
  public String ok(){
    return "ok";
  }

}

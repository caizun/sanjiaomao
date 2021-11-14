package xyz.sanjiaomao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-08-02 22:21
 */
@SpringBootApplication
@MapperScan("xyz.sanjiaomao.infrastructure.mapper")
@EnableAspectJAutoProxy
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}

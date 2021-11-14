package xyz.sanjiaomao.infrastructure.auth;

import java.lang.annotation.*;

/**
 * <pre>
 *  角色编码
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-11-14 22:39
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Role {

  String value();
}

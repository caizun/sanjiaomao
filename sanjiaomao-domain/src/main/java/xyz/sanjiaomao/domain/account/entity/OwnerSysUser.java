package xyz.sanjiaomao.domain.account.entity;

/**
 * <pre>
 *  账号归属
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-09-01 00:36
 */
public interface OwnerSysUser {

  SysUserEntity findByAccountId(Long accountId);

}
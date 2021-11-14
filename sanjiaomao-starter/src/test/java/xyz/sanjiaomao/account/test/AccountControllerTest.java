package xyz.sanjiaomao.account.test;

import cn.hutool.json.JSONUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.WebApplicationContext;
import xyz.sanjiaomao.Application;
import xyz.sanjiaomao.api.account.AccountController;
import xyz.sanjiaomao.domain.account.cmd.CreateAccountCmd;
import xyz.sanjiaomao.domain.account.cmd.LoginCmd;
import xyz.sanjiaomao.infrastructure.account.dataobject.AccountDO;
import xyz.sanjiaomao.infrastructure.account.qry.AccountQry;
import xyz.sanjiaomao.infrastructure.auth.AuthFilter;
import xyz.sanjiaomao.infrastructure.mapper.AccountMapper;
import xyz.sanjiaomao.infrastructure.utils.CacheAccountRecordUtils;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;


/**
 * <pre>
 *
 * </pre>
 *
 * @author 李宇飞
 * create by 2021-10-18 21:24
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountControllerTest {

  @Resource
  private WebApplicationContext webApplicationContext;

  @Resource
  private AccountController accountController;

  @Resource
  private AccountMapper accountMapper;


  private MockMvc mockMvc;

  @Before
  public void before(){
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(new AuthFilter()).build();
  }


  @Test
  public void registry(){
    CreateAccountCmd cmd = new CreateAccountCmd();
    cmd.setAccount("administrator");
    cmd.setPassword("administrator");
    cmd.setRePassword("administrator");
    cmd.setNickname("administrator");
    accountController.registry(cmd);

    AccountQry qry = new AccountQry();
    qry.setAccount(cmd.getAccount());
    List<AccountDO> listAccountDO = accountMapper.select(qry);
    assert !CollectionUtils.isEmpty(listAccountDO);
    AccountDO accountDO = listAccountDO.get(0);
    assert Objects.equals(accountDO.getPassword(), cmd.getPassword());

  }

  @Test
  public void login() throws Exception {
    LoginCmd cmd = new LoginCmd();
    cmd.setAccount("administrator");
    cmd.setPassword("administrator");
    accountController.login(cmd);

    MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post("/public/account/record")
        .contentType(MediaType.APPLICATION_JSON)
        .content(JSONUtil.toJsonStr(cmd).getBytes(StandardCharsets.UTF_8))
    ).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.cookie().exists("account"))
        .andReturn().getResponse();

    Cookie cookie = response.getCookie("account");
    assert cookie != null;
    String id = cookie.getValue();
    AccountDO accountDO = CacheAccountRecordUtils.get(id);
    assert accountDO != null;
  }


}

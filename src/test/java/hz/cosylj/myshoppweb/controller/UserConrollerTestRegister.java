package hz.cosylj.myshoppweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import hz.cosylj.myshoppweb.boot.MVCConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * Created by cosy on 2017/3/3.
 */

@ActiveProfiles("src/test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { MVCConfig.class})
@Transactional
public class UserConrollerTestRegister {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public  void setup() throws  Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }



    /**
     * 检测用户能否正常注册
     */

    @Test
    @Rollback
    public void register() throws Exception
    {
        MvcResult mvcResult=mockMvc.perform(get("/user/register")
                                   .param("userName","aa")
                                   .param("passWord","123456")
                                   .param("comfigPwd","123456"))
                                   .andExpect(view().name("login.html"))
                                   .andReturn();
        String view=mvcResult.getModelAndView().getViewName().toString();
        Assert.assertEquals("login.html",view);

    }


    /**
     * 注册时校验用户名，已经存在的用户名提示"该用户已经存在"
     * @throws Exception
     */
    @Test
    @Rollback
    public void exitUser() throws Exception
    {
        MvcResult mvcResult=mockMvc.perform(get("/user/checkUserName")
                                   .param("username","cosylj"))
                                   .andReturn();
        String string=new String(mvcResult.getResponse().getContentAsByteArray(),"UTF-8");
        JSONObject obj1= JSONObject.parseObject(string);
        Assert.assertEquals("该用户已经存在!!",obj1.get("message"));
        Assert.assertEquals("400",obj1.get("code"));
    }

    @Test
    @Rollback

    public void noExitUser()throws Exception
    {
          MvcResult mvcResult=mockMvc.perform(get("/user/checkUserName")
                                     .param("username","aa"))
                                     .andReturn();
          String string=new String(mvcResult.getResponse().getContentAsByteArray(),"UTF-8");
          JSONObject object= JSON.parseObject(string);
          Assert.assertEquals("该用户不存在!!",object.get("message"));
          Assert.assertEquals("200",object.get("code"));
    }
}

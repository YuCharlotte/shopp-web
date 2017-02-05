package hz.cosylj.myshoppweb.controller;

import hz.cosylj.myshoppweb.base.baseClass;
import hz.cosylj.myshoppweb.boot.MVCConfig;

import hz.cosylj.myshoppweb.entity.User;
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


import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by cosy on 2016/11/21.
 */


@ActiveProfiles("src/test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { MVCConfig.class})
@Transactional
public class UserConrollerTestLogin extends baseClass {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private  MockMvc  mockMvc;

    @Before
    public  void setup() throws  Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    //不存在的用户名和密码，提示用户名和密码错误
      public void nullUsernameAndPaw() throws Exception
      {
         MvcResult mvcResult= mockMvc.perform(get("/user/login")
                                      .param("username","cosyljj")
                                      .param("password","123456"))
                                      .andExpect(view().name("login.html"))
                                      .andExpect(model().attributeExists("message"))
                                      .andReturn();
          /*String result=new String(mvcResult.getResponse().getContentAsByteArray(),"UTF-8");
          JSONObject jsonObject=JSONObject.parseObject(result);
          Assert.assertEquals(200,jsonObject.get("code"));
          Assert.assertEquals("用户名和密码错误",jsonObject.get("message"));*/

          String viewname=mvcResult.getModelAndView().getViewName().toString();
          Map<String,Object> usermap=(Map<String,Object>)mvcResult.getModelAndView().getModel().get("message");
          Map.Entry<String,Object> mapentry=(Map.Entry<String,Object>)usermap.entrySet();
          Assert.assertEquals("login.html",viewname);
          Assert.assertEquals("用户名或密码错误，请仔细核对！！！",mapentry.getValue());
          Assert.assertEquals(1,usermap.size());

      }


    //存在的用户名和密码，登入成功

      @Rollback
      @Test
      public  void  login() throws Exception
      {
         MvcResult mvcResult=mockMvc.perform(get("/user/login")
                                    .param("username","cosylj")
                                    .param("password","123456"))
                                    .andExpect(view().name("index.html"))
                                    .andExpect(model().attributeExists("usermap"))
                                    .andReturn();

          String view=mvcResult.getModelAndView().getView().toString();
          Map<String,Object> usermap=(Map<String,Object>)mvcResult.getModelAndView().getModel().get("user");
          Map.Entry<String,Object> mapentry=(Map.Entry<String,Object>)usermap.entrySet();
          User user=(User)mapentry.getValue();

          Assert.assertEquals("index.html",view);
          Assert.assertEquals(1,usermap.size());
          Assert.assertEquals("cosylj",user.getUsername());

      }

}

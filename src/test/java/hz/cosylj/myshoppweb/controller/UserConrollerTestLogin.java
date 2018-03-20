package hz.cosylj.myshoppweb.controller;


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
public class UserConrollerTestLogin  {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private  MockMvc  mockMvc;

    @Before
    public  void setup() throws  Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }




    /**
     *  不存在的用户名和密码，提示用户名和密码错误
     * @throws Exception
     */
      @Test
      @Rollback
      public void nullUsernameAndPaw() throws Exception
      {
          MvcResult mvcResult= mockMvc.perform(get("/user/login")
                  .param("username","cosyljl")
                  .param("password","123456"))
                  .andExpect(view().name("/login.html"))
                  .andExpect(model().attributeExists("message"))
                  .andReturn();


          String viewname=mvcResult.getModelAndView().getViewName().toString();
          Object message= mvcResult.getModelAndView().getModel().get("message");



          Assert.assertEquals("/login.html",viewname);
           Assert.assertEquals("用户名或密码错误，请仔细核对！！！",message);

      }


    /**
     * 存在正确的用户名，检测能否进入到指定页面
     * @throws Exception
     */
      @Rollback
      @Test
      public  void  login() throws Exception
      {
         MvcResult mvcResult=mockMvc.perform(get("/user/login")
                                    .param("username","cosylj")
                                    .param("password","123456"))
                                    .andExpect(view().name("/pages/index.html"))
                                    .andExpect(model().attributeExists("user"))
                                    .andReturn();

          String view=mvcResult.getModelAndView().getViewName().toString();
          User user =(User) mvcResult.getModelAndView().getModel().get("user");
         // Map.Entry<String,Object> mapentry=(Map.Entry<String,Object>)usermap.entrySet();


          Assert.assertEquals("/pages/index.html",view);
          Assert.assertEquals("cosylj",user.getUsername());
          Assert.assertEquals("123456",user.getPassword());

      }

}

package hz.cosylj.myshoppweb.controller;

import hz.cosylj.myshoppweb.boot.MVCConfig;


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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by cosy on 2016/10/9.
 */



@ActiveProfiles("src/test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { MVCConfig.class})
@Transactional
public class eventest
{

    @Autowired
    private WebApplicationContext webApplicationContext;

    private  MockMvc  mockMvc;


   /* 初始化mock*/

    @Before
    public void setUp() throws Exception {
       mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Rollback(value = false)
    @Test
    public  void aa() throws Exception
    {
/*

        UserOperService UserOperService=new findUserImpl();
        UserOperService.login("cosylj","123456");
*/


        mockMvc.perform(get("/bbb/aa").param("goodsname","cosygood").param("username","cosylj")).andExpect(status().isOk());
        System.out.print("这是aaa的测试.....");

    }


}

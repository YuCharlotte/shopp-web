package hz.cosylj.myshoppweb.controller;

import hz.cosylj.myshoppweb.boot.MVCConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by cosy on 2018/2/26.
 */

@ActiveProfiles("src/test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { MVCConfig.class})
@Transactional
public class Test1 {


    @Test
    public void replace()throws Exception
    {
           String string="a|b|cd";
           System.out.println("==================="+string.replace("|", "/"));
           System.out.println("==================="+string.replaceAll("|", "/"));
           System.out.println("==================="+string.replaceFirst("|", "/"));
    }

    @Test
    public void split(){
 /*       String string="a.b.c.d";
        System.out.println("==================="+string.split("/."));
*/
        String string2="ab|cd";
        String[] stringsarr=string2.split("/|");

       /* for(int i=0;i<=stringsarr.length;i++){
            System.out.println("==================="+i);
        }*/


        for(String a:string2.split("/|")){
            System.out.println("==================="+a);
        }


    }
}



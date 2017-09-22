package hz.cosylj.myshoppweb.controller;


import hz.cosylj.myshoppweb.entity.User;
import hz.cosylj.myshoppweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by cosy on 2016/9/29.
 */

@RequestMapping("/bbb")
@Controller
public class test {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/aa", method = RequestMethod.GET)
    public String indext(String username,  String goodsname) {
        User user=new User();
        user.setId(12L);
        user.setUsername("liko");
        user.setPassword("123456");
        user= userRepository.saveAndFlush(user);
        System.out.println("---------------"+user.getId()+"--------------"+user.getUsername()+"--------");

        User user1=userRepository.findByUsername(username);
        if (user1==null)
        {
            System.out.println("++++++++++++++++++用户名不存在================");
        }

        System.out.println("---------------"+user1.getId()+"--------------"+user1.getUsername()+"--------");
        return "/login_v2.html";
    }

}

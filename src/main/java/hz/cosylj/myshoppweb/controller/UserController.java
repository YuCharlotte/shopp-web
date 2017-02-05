package hz.cosylj.myshoppweb.controller;

import hz.cosylj.myshoppweb.entity.User;
import hz.cosylj.myshoppweb.repository.UserRepository;

import hz.cosylj.myshoppweb.service.FindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by cosy on 2016/11/17.
 */

@Controller
@RequestMapping(value="/user")
public class UserController {


    @Autowired
    private FindUserService findUserService;




    /**
     *
     * @param usernema
     * @param password
     * @return
     */

    //用户登入
    @RequestMapping(value="/login" ,method= RequestMethod.POST)
    public ModelAndView  login(@RequestParam(value = "username") String usernema, @RequestParam(value = "password") String password)
    {
        Map<String,Object> usermap=new HashMap<String,Object>();
        User user=findUserService.login("username","password");
        if (user!=null)
        {
            usermap.put("user",user);
            return  new ModelAndView("index.html",usermap);
        }
        usermap.put("message","用户名或密码错误，请仔细核对！！！");
        return  new ModelAndView("login_v2.html",usermap);


    }

    /**
     *
     * @param username
     * @param password
     * @param agpassword
     */

    //用户注册
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public  void register(String username,String password,String agpassword)
    {

    }
    //忘记密码


}

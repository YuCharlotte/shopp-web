package hz.cosylj.myshoppweb.controller;

import hz.cosylj.myshoppweb.entity.User;
import hz.cosylj.myshoppweb.service.FindUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

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

    @RequestMapping(value = "/")
    public String login(){
        return "login.html";
    }




    /**
     *
     * @param usernema
     * @param password
     * @return
     */

    //用户登入
    @RequestMapping(value="/login" )
    public ModelAndView login(@RequestParam(value = "username") String usernema, @RequestParam(value = "password") String password , Model model)
    {

        Map<String,Object> usermap=new HashMap<String,Object>();
        ModelAndView modelAndView=new ModelAndView();
        User user=findUserService.login(usernema,password);
        if (user!=null)
        {
            usermap.put("user",user);
            modelAndView.setViewName("/pages/index.html");
            modelAndView.addObject(usermap);
        }else{
           // usermap.put("message","用户名或密码错误，请仔细核对！！！");
            modelAndView.setViewName("/login.html");
            modelAndView.addObject("message","用户名或密码错误，请仔细核对！！！");
           // model.addAttribute("message","用户名或密码错误，请仔细核对！！！");
        }
          return modelAndView;
    }

    /**
     *
     * @param usermodel 用户模型
     */

    //用户注册



    //校验用户名

    //忘记密码


}

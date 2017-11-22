package hz.cosylj.myshoppweb.controller;

import hz.cosylj.myshoppweb.entity.User;
import hz.cosylj.myshoppweb.model.ApiResultMode;
import hz.cosylj.myshoppweb.repository.UserRepository;
import hz.cosylj.myshoppweb.service.UserOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by cosy on 2016/11/17.
 */

@Controller
@RequestMapping(value="/user")
public class UserController {


    @Autowired
    private UserOperService userOperService;
    @Autowired
    private UserRepository userRepository;



 /*  @RequestMapping(value = "/login")
    public String login(){
      *//* Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("++++++++++++++++++++任务执行时间"+new Date());
            }
        },5000);
        System.out.println("+++++++++++++++++现在时间"+new Date());*//*

        return "login.html";
    }
*/

    /**
     * 用户登入
     * @param userName
     * @param passWord
     * @return
     */
    @RequestMapping(value="/login" )
    public ModelAndView login(@RequestParam(value = "username") String userName, @RequestParam(value = "password") String passWord )
    {
        ModelAndView modelAndView=new ModelAndView();
        User user= userOperService.login(userName,passWord);
        if (user!=null)
        {
            modelAndView.setViewName("/pages/index.html");
            modelAndView.addObject("user",user);
        }else{
            modelAndView.setViewName("/login.html");
            modelAndView.addObject("message","用户名或密码错误，请仔细核对！！！");
        }
          return modelAndView;
    }





    /**
     * 用户注册,成功进入login页
     * @param user
     */
    @RequestMapping(value = "/register")
    public String register(User user)
    {
        if (user!=null)
        {
            userOperService.registerUser(user);
            return "login.html";
        }
        return "pages/register.html" ;
    }


    /**
     * 检索所有用户信息，并且根据用户id删除，编辑用户
     * @return
     */
    @RequestMapping(value="/goToUserList")
    public  ModelAndView goToUserList(String userId)
    {
        ModelAndView modelAndView=new ModelAndView();
        List<User> userlist;
        //删除用户
        if(userId!=null)
        {
            userOperService.delectUser(Long.parseLong(userId));

        }

        //检索用户
        userlist=userOperService.findAllUser();
        if (userlist.size()>0)
        {
            modelAndView.setViewName("pages/users.html");
            modelAndView.addObject("userlist",userlist);
        }
        return modelAndView;
    }


    /**
     * 编辑商品时获得商品
     * @param userId
     * @return
     */
    @RequestMapping(value="/userEdit")
    public ModelAndView userEdit(@RequestParam(value="userId") long userId){
        ModelAndView modelAndView=new ModelAndView();

        User user=userRepository.findOne(userId);
        if(user!=null){
            modelAndView.setViewName("pages/userEdit.html");
            modelAndView.addObject("user",user);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/userUpdate" , produces = "application/json")
    public @ResponseBody ApiResultMode updateUser(User user) {
        //编辑用户

        if (user.getUsername() == null && user.getUsername() == "") {
            return new ApiResultMode("用户名不能为空");
        }
        if (user.getAddress() == null) {
            return new ApiResultMode("地址不能为空");
        }
        if (user.getUseridentity() == null) {
            return new ApiResultMode("等级不能为空");
        }
        System.out.println("==============" + user.getUsername());
        ApiResultMode apiResultMode = new ApiResultMode();

        if (user!=null){

        }

        return apiResultMode;

    }
}

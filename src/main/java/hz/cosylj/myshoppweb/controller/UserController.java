package hz.cosylj.myshoppweb.controller;

import hz.cosylj.myshoppweb.entity.User;
import hz.cosylj.myshoppweb.model.RegisterMode;
import hz.cosylj.myshoppweb.repository.UserRepository;
import hz.cosylj.myshoppweb.service.UserOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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



    @RequestMapping(value = "/")
    public String login(){
        return "login.html";
    }


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
     * 跳转到用户注册页面
     */

    @RequestMapping(value = "/goToRegisterPage")
    public  String goToRegisterPage()
    {

       return "pages/register.html";
    }


    /**
     * 用户注册,成功进入login页
     * @param RegisterMode
     */
    @RequestMapping(value = "/register")
    public String register(RegisterMode RegisterMode)
    {
        if (RegisterMode!=null)
        {
            User user=new User();
            user.setUsername(RegisterMode.getUserName());
            user.setPassword(RegisterMode.getPassWord());
            userOperService.registerUser(user);
            return "login.html";
        }
        return "pages/register.html" ;
    }


    /**
     * 检索所有用户信息，并且根据用户id删除用户
     * @return
     */
    @RequestMapping(value="/goToUserList")
    public  ModelAndView goToUserList(String userId)
    {
        ModelAndView modelAndView=new ModelAndView();
        if(userId!=null)
        {
            userOperService.delectUser(Long.parseLong(userId));
        }

        List<User> userlist=userOperService.findAllUser();
        if (userlist.size()>0)
        {
            modelAndView.setViewName("pages/users.html");
            modelAndView.addObject("userlist",userlist);
        }
        return modelAndView;
    }


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
}

package hz.cosylj.myshoppweb.controller;

import com.alibaba.fastjson.JSONObject;
import hz.cosylj.myshoppweb.entity.User;
import hz.cosylj.myshoppweb.model.ApiResultMode;
import hz.cosylj.myshoppweb.model.RegisterMode;
import hz.cosylj.myshoppweb.repository.UserRepository;
import hz.cosylj.myshoppweb.service.UserOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;




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
     *
     * 用户登入
     * @param userName
     * @param passWord
     * @return
     */

    @RequestMapping(value="/login" )
    public ModelAndView login(@RequestParam(value = "username") String userName, @RequestParam(value = "password") String passWord )
    {
        /*String name=userName.trim();
        String word=passWord.trim();*/
      //  Map<String,Object> userMap=new HashMap<String,Object>();
        ModelAndView modelAndView=new ModelAndView();
        User user= userOperService.login(userName,passWord);
        if (user!=null)
        {
          //  userMap.put("user",user);
            modelAndView.setViewName("/pages/index.html");
            modelAndView.addObject("user",user);
        }else{
           // usermap.put("message","用户名或密码错误，请仔细核对！！！");
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
     * 校验用户名是否可以使用
     *
     * @param userName  用户名
     */
    @RequestMapping(value="/checkUserName",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String checkUsername(@RequestParam(value="username") String userName)
    {

        ApiResultMode apiResultMode=new ApiResultMode();
        User user=userRepository.findByUsername(userName);
        if (user!=null)
        {
            apiResultMode.setMessage("该用户已经存在!!");
            apiResultMode.setCode("400");
            return JSONObject.toJSONString(apiResultMode);
        }

            apiResultMode.setMessage("该用户不存在!!");
            apiResultMode.setCode("200");
            return JSONObject.toJSONString(apiResultMode);
    }

    //忘记密码


}

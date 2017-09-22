package hz.cosylj.myshoppweb.service.impl;


import com.alibaba.fastjson.JSONObject;
import hz.cosylj.myshoppweb.entity.User;
import hz.cosylj.myshoppweb.model.ApiResultMode;
import hz.cosylj.myshoppweb.repository.UserRepository;
import hz.cosylj.myshoppweb.service.UserOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cosy on 2016/11/17.
 */

@Service
public class UserOperImpl implements UserOperService {

    @Autowired
    UserRepository userRepository;


    /**
     * 用户登入
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {


       User user=userRepository.findByUsername(username);

        if(user!=null)
        {

           if (user.getPassword().equals(password))
           {
               return user;
           }
        }
        return null;
    }


    /**
     * 用户注册
     * @param user
     */
    public void registerUser(User user) {
        if(user!=null)
        {
            userRepository.saveAndFlush(user);
        }

    }

    /**
     * 校验用户名是否存在
     * @param userName
     * @return
     */

    public String checkUsername(String userName)
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


    /**
     * 检索所有用户
     * @return
     */
    public List findAllUser()
    {
        List<User> userlist=userRepository.findAll();
        return userlist;
    }


    /**
     *
     * @param userId
     */
    public void delectUser(Long userId)
    {
        if (userId!=null)
        {
            userRepository.delete(userId);
        }

    }

    /**
     * 更新用户信息，用于编辑
     */
    public void updateUser(User user){

    }


}

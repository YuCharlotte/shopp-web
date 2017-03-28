package hz.cosylj.myshoppweb.service.impl;


import hz.cosylj.myshoppweb.entity.User;
import hz.cosylj.myshoppweb.repository.UserRepository;
import hz.cosylj.myshoppweb.service.UserOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cosy on 2016/11/17.
 */

@Service
public class UserOperImpl implements UserOperService {

    @Autowired
    UserRepository userRepository;


    //用户登入
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


    //用户注册
    public void registerUser(User user) {
        if(user!=null)
        {
            userRepository.saveAndFlush(user);
        }

    }
}

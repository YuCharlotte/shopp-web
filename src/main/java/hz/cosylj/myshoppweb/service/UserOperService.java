package hz.cosylj.myshoppweb.service;

import hz.cosylj.myshoppweb.entity.User;

import java.util.List;

/**
 * Created by cosy on 2016/11/17.
 */


public interface UserOperService {



     User login(String username,String password);

     void registerUser (User user);

     String checkUsername(String userName);



     List<User> findAllUser();

     void delectUser(Long userId);

     void updateUser(User user);
}

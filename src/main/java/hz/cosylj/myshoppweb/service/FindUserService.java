package hz.cosylj.myshoppweb.service;

import hz.cosylj.myshoppweb.entity.User;

/**
 * Created by cosy on 2016/11/17.
 */


public interface FindUserService {



     User login(String username,String password);

     User registerUser (User user);
}

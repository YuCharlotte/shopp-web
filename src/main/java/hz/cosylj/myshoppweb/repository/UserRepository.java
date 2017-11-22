package hz.cosylj.myshoppweb.repository;

import hz.cosylj.myshoppweb.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by cosy on 2016/11/21.
 */
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {



   /*
.
      根据用户名获取用户

  */

    User findByUsername(String username);
}

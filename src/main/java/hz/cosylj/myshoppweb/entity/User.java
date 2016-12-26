package hz.cosylj.myshoppweb.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by cosy on 2016/11/17.
 */

@Entity
@Getter
@Setter
public class User {


    /*
    * 用户id
    * */
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(length = 32, nullable = false)
    private Long id;


    /*
  * 用户名称
  * */
    @Column
    private  String username;


    /*
    * 登入密码
* */
    @Column
    private  String password;



    /*用户头像*/
    @Column
    private String headimg;


    /*用户住址*/
    @Column
    private  String address;


   /* 用户身份*/
    @Column
    private  String useridentity;


}

package hz.cosylj.myshoppweb.entity;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by cosy on 2016/9/30.
 */


@Entity
@Getter
@Setter
public class Goods {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(length = 32, nullable = false)
    private Long id;

    @Column
    private  String name;
    }

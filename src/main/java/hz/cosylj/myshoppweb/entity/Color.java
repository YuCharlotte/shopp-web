package hz.cosylj.myshoppweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by cosy on 2018/3/6.
 */

@Entity
@Getter
@Setter
public class Color {
    /**
     * 颜色Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Color_Id")
    private Long id;


    @Column(name="colorName")
    private String colorName;

    @OneToMany( targetEntity= Size.class)
    private List sizeList;







}

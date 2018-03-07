package hz.cosylj.myshoppweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.PrintConversionEvent;
import java.awt.*;
import java.awt.Color;
import java.util.*;
import java.util.List;

/**
 * Created by cosy on 2018/3/6.
 */

@Entity
@Getter
@Setter
public class Goods {
    /**
     * 商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品名称
     *
     */

    @Column
    private String goodName;
    /**
     * 商品的品牌
     */


    @Column(name="number")
    private String number;

    /**
     * 价格
     */
    @Column(name="price")
    private String price;

    /**
     * 商品颜色
     */
    @OneToMany(targetEntity = Color.class)
    @JoinColumn(name="Color_Id")
    private List<Color> color;

}

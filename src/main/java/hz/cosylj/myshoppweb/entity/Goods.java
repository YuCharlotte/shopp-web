package hz.cosylj.myshoppweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.PrintConversionEvent;
import java.awt.*;

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
    @Column(name="brand")
    private String brand;

    /**
     * 款号
     */

    @Column(name="number")
    private String number;

    /**
     * 价格
     */
    @Column(name="price")
    private String price;

}

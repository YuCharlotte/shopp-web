package hz.cosylj.myshoppweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by cosy on 2018/3/6.
 */

@Entity
@Getter
@Setter
public class Size {

    /**
     * SizeId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    /**
     * 尺寸名称
     */
    @Column(name="SizeName")
    private String SizeName;


    @ManyToOne
    private Color color;
}

package hz.cosylj.myshoppweb.controller;

import hz.cosylj.myshoppweb.entity.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cosy on 2018/3/6.
 */
@Controller
@RequestMapping(value="/goods")
public class GoodsController {


    @RequestMapping(value="/findgood" )
    public Goods findAllGood(){
        return null;
    }

}

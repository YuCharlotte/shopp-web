package hz.cosylj.myshoppweb.controller;

import hz.cosylj.myshoppweb.entity.Goods;
import hz.cosylj.myshoppweb.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cosy on 2018/3/6.
 */
@Controller
@RequestMapping(value="/goods")
public class GoodsController {
   @Autowired
    GoodsRepository goodsRepository;

    @RequestMapping(value="/findgood",produces = "application/json" )
    public ModelAndView findGoodById(String id){
        if (id!= null && id.length()>0 ){
            Goods goods;
           // goods=goodsRepository.findGoodById(Integer.parseInt(id));
        }

        return null;

    }

}

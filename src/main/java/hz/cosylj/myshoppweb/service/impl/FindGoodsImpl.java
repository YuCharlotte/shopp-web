package hz.cosylj.myshoppweb.service.impl;

import hz.cosylj.myshoppweb.entity.Goods;
import hz.cosylj.myshoppweb.model.Goodsmodel;
import hz.cosylj.myshoppweb.service.FindGoodsService;
import org.springframework.stereotype.Service;

/**
 * Created by cosy on 2016/10/20.
 *
 */

@Service
public class FindGoodsImpl implements FindGoodsService {

    public Goodsmodel findById(String id) {
        Goods goods=new Goods();
        goods.setId(1L);
        goods.setName("UserRepository");
        Goodsmodel goodsmodel=new Goodsmodel();
        goodsmodel.setId(goods.getId());
        goodsmodel.setName(goods.getName());
        return goodsmodel;
    }
}

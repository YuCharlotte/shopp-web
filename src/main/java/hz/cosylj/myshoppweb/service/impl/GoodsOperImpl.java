package hz.cosylj.myshoppweb.service.impl;

import hz.cosylj.myshoppweb.entity.Goods;
import hz.cosylj.myshoppweb.repository.GoodsRepository;
import hz.cosylj.myshoppweb.service.GoodsOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cosy on 2018/3/6.
 */
@Service
public class GoodsOperImpl implements GoodsOperService {
     @Autowired
    GoodsRepository goodsRepository;

    public Goods findGoodsByGoodid(int id) {
       Goods goods;

        return null;
    }
}

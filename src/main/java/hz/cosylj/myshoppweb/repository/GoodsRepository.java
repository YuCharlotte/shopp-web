package hz.cosylj.myshoppweb.repository;

import hz.cosylj.myshoppweb.entity.Goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by cosy on 2016/10/20.
 */
public interface GoodsRepository extends JpaRepository<Goods,Long>, JpaSpecificationExecutor<Goods> {
    //对数据库的操作在这里
}

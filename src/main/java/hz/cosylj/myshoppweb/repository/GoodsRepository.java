package hz.cosylj.myshoppweb.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import hz.cosylj.myshoppweb.entity.Goods;
import hz.cosylj.myshoppweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.awt.*;

/**
 * Created by cosy on 2018/3/7.
 */
public interface GoodsRepository extends JpaRepository<Goods,Long>,JpaSpecificationExecutor<Goods> {

   // Goods findGoodById(int ID);

}

package hz.cosylj.myshoppweb.model;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by cosy on 2016/12/15.
 */

@Getter
@Setter
public class ApiResultMode {

    /**
     * 编码
     * 1成功 其他失败
     */
    private  String code;

    /**
     * 提示信息
     */
    private  String message;


    /**
     * 数据
     */
    private  Object date;
}

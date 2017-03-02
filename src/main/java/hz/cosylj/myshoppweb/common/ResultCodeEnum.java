package hz.cosylj.myshoppweb.common;

/**
 * Created by cosy on 2017/2/23.
 */
public enum ResultCodeEnum {

    SUCCESS(200, "请求成功"),
    USERNAME_NULL(401,"用户名不能为空"),
    PASSWORD_NULL(402,"密码不能为空"),
    USERNAME_OR_PASSWORD_WRONG(403,"用户名或密码错误"),
    SYSTEM_BAD_REQUEST(500,"系统请求失败"),
    DATA_BAD_PARSER(600,"数据解析失败"),
    SIGN_ERROR(300,"签名错误"),
    NO_SIGN(301,"签名参数未传"),
    LOGINNAME_NOT_AVAILABLE(100,"用户名已存在"),
    AUTHORITY_NULL(700,"请设置权限"),
    SAVE_DATA_ERROR(400,"数据保存出错"),
    SUPPLIER_NOT_FOUND(250,"还未开通供应商账户"),
    SETTLEMENTNO_NULL(251,"结算单编号为空"),
    DATA_NULL(500,"没有传输数据");


    private int resultCode;
    private  String resultMsg;


     ResultCodeEnum(int resultCode, String resultMsg)
    {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }
}

package xyz.cchili.springcloud.cloudapicommons.vo;

/**
 * @author CQSuagr
 * @date 创建时间:2020/4/19 14:43
 */
public enum ResultCode {
    /* 成功 */
    SUCCESS(20000, "成功"),
    NO_DATA(20001,"未查询到数据"),

    /* 默认失败 */
    COMMON_FAIL(99999, "失败"),

    /* 参数错误：10000～19999 */
    PARAM_NOT_VALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),

    /* 用户错误 */
    USER_NOT_LOGIN(20001, "用户未登录"),
    USER_ACCOUNT_EXPIRED(20002, "账号已过期"),
    USER_CREDENTIALS_ERROR(20003, "密码错误"),
    USER_CREDENTIALS_EXPIRED(20004, "密码过期"),
    USER_ACCOUNT_DISABLE(20005, "账号不可用"),
    USER_ACCOUNT_LOCKED(20006, "账号被锁定"),
    USER_ACCOUNT_NOT_EXIST(20007, "账号不存在或密码错误"),
    USER_ACCOUNT_ALREADY_EXIST(20008, "账号已存在"),
    USER_ACCOUNT_USE_BY_OTHERS(20009, "账号下线"),

    /* 业务错误 */
    NO_PERMISSION(30001, "没有权限");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 根据code获取message
     *
     */
    public static String getMessageByCode(Integer code) {
        for (ResultCode ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele.getMessage();
            }
        }
        return null;
    }

}

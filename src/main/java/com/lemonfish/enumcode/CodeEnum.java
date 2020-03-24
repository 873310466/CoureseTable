package com.lemonfish.enumcode;

/**
 * @author Masics 张超
 * @date 2020/2/26 0:54
 */
public enum CodeEnum {
    /***
     * 请求处理成功
     */
    OK(200, "操作成功"),


    /***
     * 部分成功（一般用于批量处理场景，只处理筛选后的合法数据）
     */
    WARN_PARTIAL_SUCCESS(1001, "部分成功"),

    /***
     * 有潜在的性能问题
     */
    WARN_PERFORMANCE_ISSUE(1002, "潜在的性能问题"),

    /***
     * 传入参数不对
     */
    FAIL_INVALID_PARAM(4000, "请求参数不匹配"),

    /***
     * Token无效或已过期
     */
    FAIL_INVALID_TOKEN(4001, "Token无效或已过期"),

    /***
     * Token无效或已过期
     */
    FAIL_LOGIN_ERROR(4002, "帐号或密码错误"),

    /***
     * 没有权限执行该操作
     */
    FAIL_NO_PERMISSION(4003, "无权执行该操作"),

    /***
     * 请求资源不存在
     */
    FAIL_NOT_FOUND(4004, "请求资源不存在"),

    /***
     * 数据校验不通过
     */
    FAIL_VALIDATION(4005, "数据校验不通过"),

    /***
     * 操作执行失败
     */
    FAIL_OPERATION(4006, "操作执行失败"),

    /***
     * 系统异常
     */
    FAIL_EXCEPTION(5000, "系统异常"),


    /***
     * 缓存清空
     */
    MEMORY_EMPTY_LOST(9999, "缓存清空");


    CodeEnum() {
    }

    CodeEnum(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    private int code;
    private String label;
}

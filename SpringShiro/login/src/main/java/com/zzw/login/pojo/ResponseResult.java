package com.zzw.login.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @name ResponseResult
 * @description
 * @date 2019-04-26
 */

public class ResponseResult {
    //状态码
    private int code;
    //提示信息
    private String msg;
    //用户要返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<String, Object>();

    public static ResponseResult success() {
        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setMsg("处理成功！");
        return result;
    }

    public static ResponseResult success(String msg) {
        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }

    public static ResponseResult success(int code, String msg) {
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static ResponseResult fail() {
        ResponseResult result = new ResponseResult();
        result.setCode(400);
        result.setMsg("处理失败！");
        return result;
    }

    public static ResponseResult fail(String msg) {
        ResponseResult result = new ResponseResult();
        result.setCode(400);
        result.setMsg(msg);
        return result;
    }

    public static ResponseResult fail(int code, String msg) {
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public ResponseResult add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}

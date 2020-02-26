package com.liang.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/25 23:50
 * @content 接口返回数据封装类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerResponse<T> {
    private int status;
    private String msg;
    private T data;

    public static ServerResponse ok(){
        return new ServerResponse(200, "ok", null);
    }

    public static ServerResponse errMsg(String msg){
        return new ServerResponse(500,msg,null);
    }


}
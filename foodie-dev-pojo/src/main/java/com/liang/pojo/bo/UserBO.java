package com.liang.pojo.bo;

import lombok.Data;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/26 21:32
 * @content
 */
@Data
public class UserBO {
    private String username;
    private String password;
    private String confirmPassword;
}

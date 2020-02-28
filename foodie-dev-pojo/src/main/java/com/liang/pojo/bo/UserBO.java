package com.liang.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/26 21:32
 * @content
 */
@ApiModel(value = "用户对象BO", description = "由客户端传入，用户注册信息封装在此entity")
@Data
public class UserBO {
    @ApiModelProperty(value = "用户名", name = "username", example = "liangyehao", required = true)
    private String username;
    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private String password;
    @ApiModelProperty(value = "确认密码", name = "confirmPassword", example = "123456")
    private String confirmPassword;
}

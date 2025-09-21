package com.heima.model.user.dtos;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Meric
 * @CreateTime: 2025-09-19
 * @Description:
 * @Version: 1.0
 */

@Data
public class LoginDTO {

    //手机号
    @ApiModelProperty("手机号")
    private String phone;

    //密码
    @ApiModelProperty("密码")
    private String password;
}

package com.heima.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.LoginDTO;
import com.heima.model.user.pojos.ApUser;

/**
*@Author: Meric
*@CreateTime: 2025-09-19
*@Description: 
*@Version: 1.0
*/

public interface ApUserService extends IService<ApUser> {
    /**
     * app端登录功能
     * @param dto
     * @return
     */
    ResponseResult Userlogin(LoginDTO dto);
}

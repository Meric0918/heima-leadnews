package com.heima.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dtos.LoginDTO;
import com.heima.model.user.pojos.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.ApUserService;
import com.heima.utils.common.AppJwtUtil;
import com.heima.utils.common.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jcodings.util.Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Meric
 * @CreateTime: 2025-09-19
 * @Description:
 * @Version: 1.0
 */

@Service
@Transactional
@Slf4j
public class ApUserServiceImpl extends ServiceImpl<ApUserMapper, ApUser> implements ApUserService {
    /**
     * app端登录功能
     * @param dto
     * @return
     */
    @Override
    public ResponseResult Userlogin(LoginDTO dto) {
        //1.正常登录（手机号+密码登录）
        if (!StringUtils.isBlank(dto.getPhone()) && !StringUtils.isBlank(dto.getPassword())) {
            //1.1查询用户
//            LambdaQueryWrapper<ApUser> queryWrapper = new LambdaQueryWrapper<>();
//            queryWrapper.eq(ApUser::getPhone, dto.getPhone());
//            ApUser apUser = getOne(queryWrapper);

            ApUser apUser = getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getPhone, dto.getPhone()));
            if(apUser == null){
                return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
            }

            //1.2 比对密码
            String pwd = dto.getPassword() + apUser.getSalt();
           if(!DigestUtils.md5DigestAsHex(pwd.getBytes()).equals(apUser.getPassword())){
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
            }

            //1.3 返回数据  jwt
            Map<String ,Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(apUser.getId().longValue()));
            apUser.setSalt("");
            apUser.setPassword("");
            map.put("user",apUser);
            return ResponseResult.okResult(map);
        }

        //2.游客登录
        else{
            Map<String ,Object> map = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(0L));
            return ResponseResult.okResult(map);
        }
    }
}

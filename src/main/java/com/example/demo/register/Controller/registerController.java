package com.example.demo.register.Controller;

import com.example.demo.register.Entity.registerEntity;
import com.example.demo.register.Service.registerService;
import com.example.demo.util.AuthUtils;
import com.example.demo.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController

@RequestMapping("register")
public class registerController {
    private static final Logger logger = LoggerFactory.getLogger(registerController.class);

    @Resource
    private registerService registerService;

    /**
     * 用户注册 新增用户
     * @param registerEntity
     * @return Response
     * @author scout
     * @Date 2020年4月15日
     */
    @PostMapping("addUser")
    public ResponceData addUser(registerEntity registerEntity){
        try{
            //获取用户ID
            String userId = AuthUtils.getCurrentUserId();
            registerEntity.setCreate_by(userId);
            ResponceData responce = registerService.addUser(registerEntity);
            return  responce;
        }catch (Exception e){
            logger.error("用户新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

}

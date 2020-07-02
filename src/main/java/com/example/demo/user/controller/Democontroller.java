package com.example.demo.user.controller;


import com.example.demo.user.services.DemoSerive;
import com.example.demo.user.entity.UserInfo;
import com.example.demo.util.ResponceData;
import com.example.demo.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class Democontroller {
    private static final Logger logger = LoggerFactory.getLogger(Democontroller.class);

    @Resource
    private DemoSerive demoService;
    /**
     * 新增用户
     * @param userInfo
     * @return Response
     * @author scout
     * @Date 2020-03-25.
     */
    @PostMapping("saveUser")
    public ResponceData saveUser(UserInfo userInfo){
        try{
            //获取用户ID
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreate_by(userId);
            ResponceData responce = demoService.saveUser(userInfo);
            return  responce;
        }catch (Exception e){
            logger.error("用户新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 修改用户
     *
     * @param userInfo
     * @return Response
     * @author scout
     * @Date 2020-03-25
     */
    @PostMapping("updateUser")
    public ResponceData updateUser(UserInfo userInfo){
            try{
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreate_by(userId);
            userInfo.setLast_modified_by(userId);
            return demoService.updateUser(userInfo);
        }catch (Exception e){
            logger.error("修改用户失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除用户
     * @param httpServletRequest
     * @return Response
     * @author scout
     * @Date 2020-03-25
     */

      @PostMapping("deleteUser")
    public ResponceData deleteUser(HttpServletRequest httpServletRequest){

          String userCode = httpServletRequest.getParameter("listCode");
          try{
              String user_code = AuthUtils.getCurrentUserId();
              return  demoService.deleteUser(userCode,user_code);
          }catch (Exception e){
              logger.error("用户删除失败",e);
              System.out.println(e.toString());
              throw e;
          }
      }
    /**
     * 查询用户详情
     *
     * @param user_code
     * @return AResponse
     * @author scout
     * @Date 2020-03-21
     */
      @PostMapping("getUserByUserCode")
      public ResponceData getUserByUserCode(String user_code) {
          try {

              return demoService.getUserByUserCode(user_code);
          } catch (Exception e) {
              logger.error("用户查询失败",e);
              System.out.println(e.toString());
              throw e;
          }
      }
    /**
     * 用户列表(分页)
     *
     * @param userInfo
     * @return Response
     * @author scout
     * @Date 2020-03-25
     */
    @PostMapping(value = "listUsers")
    public ResponceData listUsers(UserInfo userInfo){
        try{
            return demoService.listUsers(userInfo);
        }catch (Exception e){
            logger.error("用户查询错误");
            System.out.println(e.toString());
            throw e;
        }
    }
}

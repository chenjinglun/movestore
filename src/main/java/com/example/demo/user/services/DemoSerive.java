package com.example.demo.user.services;


//import com.alibaba.fastjson.JSONObject;
import com.example.demo.user.dao.DemoDao;
import com.example.demo.user.entity.UserInfo;
//import com.example.demo.util.RedisOperator;
//import com.example.demo.util.JsonUtils;
//import com.example.demo.util.ResponceDataState;
//import com.example.demo.util.StringUtil;
//import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.example.demo.util.ResponceData;
import java.util.Arrays;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

/**
 * @DescriptionDemo 实现类
 * @Author scout
 * @Date 2020-03-25
 */
@Service
public class DemoSerive {
    private ResponceData responceData;
    @Resource
    private DemoDao demoDao;
    @Autowired
    //private RedisOperator redisOperator;
    private StringRedisTemplate redisTemplate;

    /**
     * demo 新增用户
     *
     * @param userInfo
     * @return
     * @Author scout
     * @Date 2020-03-25
     */


    @Transactional(rollbackFor = Exception.class)
    public ResponceData saveUser(UserInfo userInfo) {
        //账号是否存在

//        System.out.println(userInfo.getuse);
        int countUserAcct = demoDao.countUserAcct(userInfo);
        if (0 != countUserAcct) {
            return ResponceData.bizError("用户已存在，请重新输入");
        }
        /**
         * 他这里使用它产生一个时间戳
         */
        //userInfo.setUserCode(StringUtil.getCommonCode(2));
        userInfo.setIs_deleted(0);
        //新增用户
        int count = demoDao.saveUser(userInfo);
        if (0 == count) {
            return ResponceData.bizError("新增失败，请重试");
        }
        return ResponceData.success("新增成功！");
    }


    /**
     * 删除用户
     *
     * @param user_code
     * @param userId
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteUser(String userCode, String userId) {

        //System.out.println(userCode+","+userId);

        List<String> listCode = Arrays.asList(userCode.split(","));
        ResponceData response = ResponceData.success("删除成功");
        //删除用户
        int count = demoDao.deleteUser(listCode, userId);
        //demoDao.deleteUser(listCode,userId);
        if (0 == count) {
            response = ResponceData.bizError("删除失败，请重试！");
        }
        return response;
    }


    /**
     * 查询用户详情
     *
     * @param user_code
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    public ResponceData getUserByUserCode(String user_code) {
        UserInfo userInfo = demoDao.getUserByUserCode(user_code);
        int countUserAcct = demoDao.countUserAcct(userInfo);
        if (0 == countUserAcct) {
            return ResponceData.bizError("用户已删除，请重新输入");
        }
        return ResponceData.success("查询成功", userInfo);

    }

    /**
     * 修改用户
     *
     * @param userInfo
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateUser(UserInfo userInfo) {
        ResponceData response = ResponceData.success("修改成功");
        //检验账号是否存在
        int countUserAcct = demoDao.countUserAcct(userInfo);
        if (0 != countUserAcct) {
            return ResponceData.bizError("用户已存在，请重新输入！");
        }
        int count = demoDao.updateUser(userInfo);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }

    /**
     * 查询用户列表（分页）
     *
     * @param userInfo
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    public ResponceData listUsers(UserInfo userInfo){
        PageHelper.startPage(userInfo.getPageNum(),userInfo.getPageSize());
        List<UserInfo>userInfoList = demoDao.listUsersByPage(userInfo);
        //包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return ResponceData.success("查询成功！",pageData);
    }
    /*public ResponceData listUsers(UserInfo userInfo) {
        String userName = userInfo.getUser_name();
        String userCode = userInfo.getUser_code();
        String idCard = userInfo.getId_card();
        String PageSize = String.format("%d", userInfo.getPageSize());
        String PageNum = String.format("%d", userInfo.getPageNum());

        String keys = userName + "," + userCode + "," + idCard + "," + PageSize + "," + PageNum;

        if (null == redisTemplate.opsForValue().get(keys)) {
            if (userInfo.getPageNum() == 0 || userInfo.getPageSize() == 0) {
                responceData = new ResponceData(ResponceDataState.values()[0].getCode(), "页号不能为空！", null);
                //responce = "页号不能为空";
            }

            PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
            List<UserInfo> userInfoList = demoDao.listUsersByPage(userInfo);
            PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);

            if (pageData.getTotal() > 0) {
                responceData = new ResponceData(ResponceDataState.values()[0].getCode(), "查询成功", pageData);

                String datas = JsonUtils.toJson(pageData);

                redisTemplate.opsForValue().set(keys, datas, 300, TimeUnit.SECONDS);
            } else {
                responceData = new ResponceData(ResponceDataState.values()[3].getCode(), "查询失败", null);
                //responce = "查询失败";

            }
        } else {
            String dodo = (String)redisTemplate.opsForValue().get(keys);

            if (dodo.length() > 0) {
                JSONObject jsonObject = JSONObject.parseObject(dodo);
                responceData = new ResponceData(ResponceDataState.values()[0].getCode(), "查询成功从redis", jsonObject);
                //responce = "从redis获取";
            }

        }
        return responceData;
    }*/
}


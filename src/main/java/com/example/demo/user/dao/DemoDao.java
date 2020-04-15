package com.example.demo.user.dao;

import com.example.demo.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DemoDao
 * @Description Demo
 * @Author scout
 * @Date 2020-03-25
 */


/**
 * Mapper 层
 * Contrroler -> service -> mapper（前面要加注入，不然找不到）
 */
@Mapper
public interface DemoDao {
    /**
     * 统计用户账号数量
     * @param userInfo 用户信息
     * @return
     */

    int countUserAcct(UserInfo userInfo);

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int saveUser(UserInfo userInfo);

    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */

    List<UserInfo>listUsersByPage(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param listCode 选中的用户编号集合
     * @param userId 更新人
     * @return
     */

    int deleteUser(@Param("listCode") List<String> listCode,@Param("userId") String userId);
    //int deleteUser(String user_code);

    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUser(UserInfo userInfo);

    /**
     * 查询用户信息
     * @param userCode 用户编号
     * @return 修改结果
     */
    UserInfo getUserByUserCode(@Param("user_code") String user_code);

}

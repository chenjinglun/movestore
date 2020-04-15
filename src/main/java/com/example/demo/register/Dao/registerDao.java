package com.example.demo.register.Dao;

import com.example.demo.register.Entity.registerEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface registerDao {
    /**
     * 统计用户账号数量
     * @param registerEntity
     * @return
     */

    int countAcct(registerEntity registerEntity);
    /**
     * 新增用户
     * @paramregisterEntity
     * @return
     */
    int addUser(registerEntity registerEntity);
}

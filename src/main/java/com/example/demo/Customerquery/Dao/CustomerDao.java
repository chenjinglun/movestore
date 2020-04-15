package com.example.demo.Customerquery.Dao;

import com.example.demo.Customerquery.Entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper

/**
 * @ClassName DemoDao
 * @Description Demo
 * @Author scout
 * @Date 2020-04-01
 */
public interface CustomerDao {
    /**
     * 获取所有客户信息
     * @param CustomerEntity 客户信息
     * @return
     */
    List<CustomerEntity>queryCustomer(CustomerEntity customerEntity);
}


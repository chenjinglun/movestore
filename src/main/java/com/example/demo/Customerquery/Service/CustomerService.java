package com.example.demo.Customerquery.Service;

import com.example.demo.Customerquery.Dao.CustomerDao;
import com.example.demo.Customerquery.Entity.CustomerEntity;
import com.example.demo.util.ResponceData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;
    /**
     * demo 查询客户列表（分页）
     * @param customerEntity
     * @return
     * @Author scout
     * @Date 2020-4-1
     */
    public ResponceData queryCustomer(CustomerEntity customerEntity) {
        PageHelper.startPage(customerEntity.getPageNum(), customerEntity.getPageSize());
        List<CustomerEntity> customerList= customerDao.queryCustomer(customerEntity);
        // 包装Page对象
        PageInfo<CustomerEntity> pageData = new PageInfo<>(customerList);
        return ResponceData.success("查询成功！",pageData);
    }

}

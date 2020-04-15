package com.example.demo.Customerquery.Controller;

import com.example.demo.Customerquery.Entity.CustomerEntity;
import com.example.demo.Customerquery.Service.CustomerService;
import com.example.demo.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("customerQuery")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    private CustomerService customerService;

    /**
     *客户列表查询
     * @param
     * @return
     */

    @RequestMapping("queryCustomer")
    public ResponceData queryCustomer(CustomerEntity customerEntity) {
        try {
            return customerService.queryCustomer(customerEntity);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

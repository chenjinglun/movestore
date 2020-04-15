package com.example.demo.OredrManger.Service;

import com.example.demo.OredrManger.Dao.OrderDao;
import com.example.demo.OredrManger.Entity.OrderMangerEntity;
import com.example.demo.util.ResponceData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;
    /**
     * 查询门店信息
     * @param
     * @return StoreInEntity
     * @Author scout
     * @Date 2020年4月14日
     */
    public ResponceData queryOrderDetail(String orderId) {
        List<String> orderList= orderDao.queryOrderDetail(orderId);
        // 包装Page对象
        return ResponceData.success("查询成功！",orderList);
    }


    /**
     * 订单各个状态修改 订单状态 0已下单，1已发货，2已取消，3已完成未评价，4已完成已评价
     *
     * @param orderId
     * @return
     */

    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateOrderState(String oderNo,int orderStatus) {
        int j=0;
        List<String> listCode = Arrays.asList(oderNo.split(","));
        for(String str : listCode){
            j++;
        }
        ResponceData response = ResponceData.success("订单状态修改成功");
        //修改商品状态
        int count = orderDao.updateOrderState(listCode,orderStatus);
        if (j != count) {
            response = ResponceData.bizError("订单状态修改失败，请重试！");
        }
        return response;

    }

    /**
     * 查询订单分页
     * @param orderInfo
     * @return
     */

    public ResponceData queryOrderList(OrderMangerEntity orderMangerEntity) {
        PageHelper.startPage(orderMangerEntity.getPageNum(), orderMangerEntity.getPageSize());
        List<OrderMangerEntity> orderList= orderDao.queryOrderList(orderMangerEntity);
        // 包装Page对象
        PageInfo<OrderMangerEntity> pageData = new PageInfo<>(orderList);
        return ResponceData.success("查询成功！",pageData);
    }

}

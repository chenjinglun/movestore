package com.example.demo.OredrManger.Controller;

import com.example.demo.OredrManger.Entity.OrderMangerEntity;
import com.example.demo.OredrManger.Service.OrderService;
import com.example.demo.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("orderManger")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;


    /**
     * 查询订单详情
     *
     * @param oderNo
     * @return AppResponse
     * @author scout
     * @Date 2020年4月12日
     */
    @RequestMapping("queryOrderDetail")
    public ResponceData queryOrderDetail(String orderId) {
        try {
            return orderService.queryOrderDetail(orderId);
        } catch (Exception e) {
            logger.error("订单查询查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单各个状态修改 订单状态 0已下单，1已发货，2已取消，3已完成未评价，4已完成已评价
     *
     * @param oderNo
     * @return
     */

    @RequestMapping("updateOrderState")
    public ResponceData updateOrderState(String oderNo, int orderStatus) {
        try {
//            String goodsId=AuthUtils.getCurrentUserId();
            return orderService.updateOrderState(oderNo, orderStatus);
        } catch (Exception e) {
            logger.error("修改商品状态失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单分页
     *
     * @param orderMangerEntity
     * @return
     */
    @RequestMapping("queryOrderList")
    public ResponceData queryOrderList(OrderMangerEntity orderMangerEntity) {
        try {
//            String goodsId=AuthUtils.getCurrentUserId();
            return orderService.queryOrderList(orderMangerEntity);
        } catch (Exception e) {
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

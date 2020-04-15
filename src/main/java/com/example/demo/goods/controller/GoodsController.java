package com.example.demo.goods.controller;

import com.example.demo.goods.entity.GoodsEntity;
import com.example.demo.goods.services.GoodsService;
import com.example.demo.util.AuthUtils;
import com.example.demo.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("goodsManger")

public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;

    /**
     * 新增商品
     * @param goodsEntity
     * @return Response
     * @author scout
     * @Date 2020年4月12日
     */

    @PostMapping({"addGoods"})
    public ResponceData addGoods(GoodsEntity goodsEntity) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            goodsEntity.setCreate_by(userId);
            ResponceData responce =goodsService.addGoods(goodsEntity);
            return  responce;
        } catch (Exception e){
            logger.error("商品新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 删除商品
     * @param goodsEntity
     * @return Response
     * @author scout
     * @Date 2020年4月12日
     */
    @RequestMapping("deleteGoods")
    public ResponceData deleteGoods(HttpServletRequest httpServletRequest){
        String goodsCode = httpServletRequest.getParameter("goodsNo");
        try{
            String goodsId = AuthUtils.getCurrentUmenuId();
            return  goodsService.deleteGoods(goodsCode,goodsId);
        }catch (Exception e){
            logger.error("商品删除失败",e);
            System.out.println(e.toString());
            throw e; }
    }

    /**
     * 商品详情查询
     * @return
     * @author scout
     * @Date 2020年4月12日
     */
    @RequestMapping("queryGoodDetail")
    public ResponceData queryGoodDetail(HttpServletRequest httpServletRequest){
        String goodsCode = httpServletRequest.getParameter("goodsCode");
        try {
            return goodsService.queryGoodDetail(goodsCode);
        }catch (Exception e){
            logger.error("商品信息详情查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品信息
     * @param goodsEntity
     * @return Response
     * @author scout
     * @Date 2020年04月12日
     */
    @RequestMapping("updateGoods")
    public ResponceData updateGoods(GoodsEntity goodsEntity){
        try{
            String goodsId=AuthUtils.getCurrentUserId();
            goodsEntity.setCreate_by(goodsId);
            goodsEntity.setLast_modified_by(goodsId);
            return goodsService.updateGoods(goodsEntity);
        }catch (Exception e){
            logger.error("修改商品信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品状态
     * @param goodsEntity
     * @return Response
     * @author scout
     * @Date 2020年4月812
     */
    @RequestMapping("upperOrLowerShelf")
    public ResponceData upperOrLowerShelf (String goodsCode,int skuState){
        try{
//            String goodsId=AuthUtils.getCurrentUserId();
            return goodsService.upperOrLowerShelf(goodsCode,skuState);
        }catch (Exception e){
            logger.error("修改商品状态失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 商品列表查询详情
     * @param goodsEntity
     * @return AppResponse
     * @author scout
     * @Date 2020年4月12日
     */
    @RequestMapping("listGoods")
    public ResponceData listGoods(GoodsEntity goodsEntity) {
        try {
            return goodsService.listGoods(goodsEntity);
        } catch (Exception e) {
            logger.error("商品列表查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}

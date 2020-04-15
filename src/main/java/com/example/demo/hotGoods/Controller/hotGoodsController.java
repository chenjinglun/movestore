package com.example.demo.hotGoods.Controller;

import com.example.demo.hotGoods.Entity.hotGoodsEntity;
import com.example.demo.hotGoods.Entity.hotGoodsShowNum;
import com.example.demo.hotGoods.Entity.hotGoodslistEntity;
import com.example.demo.hotGoods.Service.hotGoodsService;
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
@RequestMapping("HotGoosManger")
public class hotGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(hotGoodsController.class);
    @Resource
    private hotGoodsService hotGoodsServicd;

    /**
     * 新增热门商品
     * @param hotGoodsEntity
     * @return Response
     * @author scout
     * @Date 2020年4月14日
     */
    @PostMapping("addHotGood")
    public ResponceData addHotGood(hotGoodsEntity hotGoodsEntity) {
        try {
            String userId = AuthUtils.getCurrentUserId();
            hotGoodsEntity.setCreate_by(userId);
            ResponceData responce =hotGoodsServicd.addHotGood(hotGoodsEntity);
            return  responce;
        } catch (Exception e){
            logger.error("热门商品新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 删除热门商品
     * @param productPop
     * @return Response
     * @author scout
     * @Date 2020年4月14日
     */
    @RequestMapping("deleteHotGood")
    public ResponceData deleteHotGood(String productPop){
        try{
            String hootGoodsId = AuthUtils.getCurrentUmenuId();
            return  hotGoodsServicd.deleteHotGood(productPop,hootGoodsId);
        }catch (Exception e){
            logger.error("热门商品删除失败",e);
            System.out.println(e.toString());
            throw e; }
    }

    /**
     * 修改热门商品信息
     * @param hotGoodsEntity
     * @return Response
     * @author scout
     * @Date 2020年4月14日16:21:19
     */
    @RequestMapping("updateHotGood")
    public ResponceData updateHotGood(hotGoodsEntity hotGoodsEntity){
        try{
            String goodsId=AuthUtils.getCurrentUserId();
            hotGoodsEntity.setCreate_by(goodsId);
            hotGoodsEntity.setLast_modified_by(goodsId);
            return hotGoodsServicd.updateHotGood(hotGoodsEntity);
        }catch (Exception e){
            logger.error("修改门店信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门商品详情查询
     * @return
     * @author scout
     * @Date 22020年4月14日
     */
    @RequestMapping("queryHotGoodDetail")
    public ResponceData queryHotGoodDetail(String productPop){
        try {
            return hotGoodsServicd.queryHotGoodDetail(productPop);
        }catch (Exception e){
            logger.error("热门商品查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 热门商品列表查询详情
     * @param hotGoodslistEntity
     * @return Response
     * @author scout
     * @Date 2020年4月14日17:10:30
     */
    @RequestMapping("queryHotGoodsList")
    public ResponceData queryHotGoodsList(hotGoodslistEntity hotGoodslistEntity) {
        try {
            return hotGoodsServicd.queryHotGoodsList(hotGoodslistEntity);
        } catch (Exception e) {
            logger.error("商品列表查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 展示数量查询
     * @return
     * @author scout
     * @Date 2020年4月12日
     */
    @RequestMapping("showHotGoodsNum")
    public ResponceData showHotGoodsNum(hotGoodsShowNum hotGoodsShowNum){
        try {
            return hotGoodsServicd.showHotGoodsNum(hotGoodsShowNum);
        }catch (Exception e){
            logger.error("商品信息详情查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改展示数量
     * @return
     * @author scout
     * @Date 2020年4月12日
     */
    @RequestMapping("updateHotGoodsNum")
    public ResponceData updateHotGoodsNum(hotGoodsShowNum hotGoodsShowNum){
        try {
            return hotGoodsServicd.updateHotGoodsNum(hotGoodsShowNum);
        }catch (Exception e){
            logger.error("商品信息详情查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

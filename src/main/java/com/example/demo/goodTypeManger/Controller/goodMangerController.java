package com.example.demo.goodTypeManger.Controller;

import com.example.demo.goodTypeManger.Entity.goodMangerEntity;
import com.example.demo.goodTypeManger.Service.goodMangerService;
import com.example.demo.util.AuthUtils;
import com.example.demo.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("goodTypeManger")
public class goodMangerController {
    private static final Logger logger = LoggerFactory.getLogger(goodMangerController.class);
    @Resource
    private goodMangerService goodMangerService;

    /**
     * 新增一级分类
     * @param
     * @return Response
     * @author scout
     * @Date 2020年4月10日
     */

    @RequestMapping("addFirstClass")
    public ResponceData addFirstClass(goodMangerEntity goodMangerEntity){
        try{
            //获取用户ID
            String userId = AuthUtils.getCurrentUserId();
            goodMangerEntity.setCreate_by(userId);
            ResponceData responce = goodMangerService.addFirstClass(goodMangerEntity);
            return  responce;
        }catch (Exception e){
            logger.error("一级分类新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 新增二级分类
     * @param
     * @return Response
     * @author scout
     * @Date 2020年4月10日
     */

    @RequestMapping("addSecondClass")
    public ResponceData addSecondClass(goodMangerEntity goodMangerEntity){
        try{
            //获取用户ID
            String userId = AuthUtils.getCurrentUserId();
            goodMangerEntity.setCreate_by(userId);
            ResponceData responce = goodMangerService.addSecondClass(goodMangerEntity);
            return  responce;
        }catch (Exception e){
            logger.error("二级分类新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 分类删除
     * @param
     * @return Response
     * @author scout
     * @Date 2020年4月10日
     */
    @RequestMapping("deleteGoodClass")
    public ResponceData deleteGoodClass(String cateCode){
        try{
            return  goodMangerService.deleteGoodClass(cateCode);
        }catch (Exception e){
            logger.error("分类删除失败",e);
            System.out.println(e.toString());
            throw e; }
    }

    /**
     * 修改分类信息
     * @param goodMangerEntity
     * @return Response
     * @author scout
     * @Date 2020年4月10日
     */
    @RequestMapping("updateGoodClass")
    public ResponceData updateGoodClass(goodMangerEntity goodMangerEntity){
        try{
            String driverId=AuthUtils.getCurrentUserId();
            goodMangerEntity.setCreate_by(driverId);
            goodMangerEntity.setLast_modified_by(driverId);
            return goodMangerService.updateGoodClass(goodMangerEntity);
        }catch (Exception e){
            logger.error("修改司机信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 分类详情查询
     * @return
     * @author scout
     * @Date 22020年4月9日
     */
    @RequestMapping("queryGoodClass")
    public ResponceData queryGoodClass(String cateCode){
        try {
            return goodMangerService.queryGoodClass(cateCode);
        }catch (Exception e){
            logger.error("分类信息查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 一级分类列表信息查询
     * @return Response
     * @author scout
     * @Date 2020年4月10日
     */
    @RequestMapping("queryGoodClassList1")
    public ResponceData queryGoodClassList1(goodMangerEntity goodMangerEntity) {
        try {
            return goodMangerService.queryGoodClassList1(goodMangerEntity);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 二级分类列表信息查询
     * @return Response
     * @author scout
     * @Date 2020年4月10日
     */
    @RequestMapping("queryGoodClassList2")
    public ResponceData queryGoodClassList2(String cateCode) {
        try {
            return goodMangerService.queryGoodClassList2(cateCode);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

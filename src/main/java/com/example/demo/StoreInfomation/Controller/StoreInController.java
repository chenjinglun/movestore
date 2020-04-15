package com.example.demo.StoreInfomation.Controller;

import com.example.demo.StoreInfomation.Entity.StoreInEntity;
import com.example.demo.StoreInfomation.Service.StoreInService;
import com.example.demo.util.AuthUtils;
import com.example.demo.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("StoreInformation")
public class StoreInController {
    private static final Logger logger = LoggerFactory.getLogger(StoreInController.class);
    @Resource
    private StoreInService storeInService;

    /**
     * 新增门店
     *
     * @param storeInEntity
     * @return Response
     * @author scout
     * @Date 2020年4月7日09:56:25.
     */

    @RequestMapping("addStore")
    public ResponceData addStore(StoreInEntity storeInEntity){
        try{
            //获取用户ID
            String userId = AuthUtils.getCurrentUserId();
            storeInEntity.setCreate_by(userId);
            ResponceData responce = storeInService.addStore(storeInEntity);
            return  responce;
        }catch (Exception e){
            logger.error("门店新增失败",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

    /**
     * 删除门店
     * @param
     * @return Response
     * @author scout
     * @Date 2020年4月8日10:48:15
     */
    @RequestMapping("deleteStore")
    public ResponceData deleteStore(HttpServletRequest httpServletRequest){
        String StoreCode = httpServletRequest.getParameter("listCode");

        try{
            String StoreID = AuthUtils.getCurrentUmenuId();

            return  storeInService.deleteStore(StoreCode,StoreID);
        }catch (Exception e){
            logger.error("门店删除失败",e);
            System.out.println(e.toString());
            throw e; }
    }

    /**
     * 门店详情查询
     * @return
     * @author scout
     * @Date 2020年4月8日
     */
    @RequestMapping("queryStoreDetail")
    public ResponceData queryStoreDetail(HttpServletRequest httpServletRequest){
        String StoreCode = httpServletRequest.getParameter("storeNO");
        int storeNO = Integer.parseInt(StoreCode);
        System.out.println(storeNO);
        try {
            return storeInService.queryStoreDetail(storeNO);
        }catch (Exception e){
            logger.error("门店信息查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店信息
     * @param updatesStore
     * @return Response
     * @author scout
     * @Date 2020年4月8日
     */
    @RequestMapping("updatesStore")
    public ResponceData updatesStore(StoreInEntity storeInEntity){
        try{
            String storeId=AuthUtils.getCurrentUserId();
            storeInEntity.setCreate_by(storeId);
            storeInEntity.setLast_modified_by(storeId);
            System.out.println(storeInEntity.toString());
            return storeInService.updatesStore(storeInEntity);
        }catch (Exception e){
            logger.error("修改门店信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 门店信息列表查询
     * @param queryCustomer
     * @return Response
     * @author scout
     * @Date 2020年4月8日
     */
    @RequestMapping("queryStoreList")
    public ResponceData queryCustomer(StoreInEntity storeInEntity) {
        try {
            return storeInService.queryStoreList(storeInEntity);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}

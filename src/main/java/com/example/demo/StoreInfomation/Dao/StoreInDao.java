package com.example.demo.StoreInfomation.Dao;

import com.example.demo.StoreInfomation.Entity.StoreInEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreInDao {
    /**
     * 新增门店
     * @param storeInEntity 门店信息
     * @return
     */
    int addStore(StoreInEntity storeInEntity);
    /**
     * 删除门店信息
     * @param  listCode2 选中菜单编号集合
     * @return
     */
    int deleteStore(@Param("listCode2") List<Integer> listCode2, @Param("StoreID") String StoreID);
    /**
     * 查询门店信息
     * @param storeNO
     * @return 修改结果
     */
    StoreInEntity queryStoreDetail(@Param("storeNO")int storeNO);
    /**
     * 按门店编号统计门店编号
     * @param
     * @return
     */
    int countStore(int storeNO);

    /**
     * 按实体统计门店编号
     * @param
     * @return
     */
    int countStoreEntity(StoreInEntity storeInEntity);

    /**
     * 修改门店信息
     * @param storeInEntity 门店信息
     * @return 修改结果
     */
    int updatesStore(StoreInEntity storeInEntity) ;

    /**
     * 获取所有门店信息
     * @param StoreInEntity 门店信息
     * @return
     */
    List<StoreInEntity>queryStoreList(StoreInEntity storeInEntity);

}

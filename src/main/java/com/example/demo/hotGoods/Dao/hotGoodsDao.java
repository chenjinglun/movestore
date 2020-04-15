package com.example.demo.hotGoods.Dao;

import com.example.demo.hotGoods.Entity.hotGoodsEntity;
import com.example.demo.hotGoods.Entity.hotGoodsShowNum;
import com.example.demo.hotGoods.Entity.hotGoodslistEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface hotGoodsDao {
    /**
     * 统计商品数量
     * @param hotGoodsEntity
     * @return
     */
    int counthotgoodsCode(hotGoodsEntity hotGoodsEntity);
    /**
     * 统计排序
     * @param hotGoodsEntity
     * @return
     */
    int countSort(hotGoodsEntity hotGoodsEntity);
    /**
     * 新增热门商品
     * @param hotGoodsEntity
     * @return
     */
    int addHotGood(hotGoodsEntity hotGoodsEntity);
    /**
     * 删除热门商品信息
     * @param  listCode 选中热门商品号集合
     * @return
     */
    int deleteHotGood(@Param("listCode") List<String> listCode, @Param("hootGoodsId") String hootGoodsId);
    /**
     * 修改热门商品信息
     * @param hotGoodsEntity 热门商品信息
     * @return 修改结果
     */
    int updateHotGood(hotGoodsEntity hotGoodsEntity) ;

    /**
     * 查询热门商品详情信息
     * @param productPop
     * @return 修改结果
     */
    hotGoodsEntity queryHotGoodDetail(@Param("productPop")String productPop);
    /**
     * 热门商品列表信息分页查询
     * @param hotGoodslistEntity 热门商品信息
     * @return
     */
    List<hotGoodslistEntity>queryHotGoodsList(hotGoodslistEntity hotGoodslistEntity);

    /**
     * 展示数量
     * @param
     * @return
     */
    hotGoodsShowNum showHotGoodsNum(hotGoodsShowNum hotGoodsShowNum);

    /**
     * 修改热门商品展示数量
     * @param hotGoodsShowNum
     * @return 修改结果
     */
    int updateHotGoodsNum(hotGoodsShowNum hotGoodsShowNum) ;

}

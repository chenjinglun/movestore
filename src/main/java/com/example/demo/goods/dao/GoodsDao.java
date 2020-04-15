package com.example.demo.goods.dao;

import com.example.demo.StoreInfomation.Entity.StoreInEntity;
import com.example.demo.goods.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {
    /**
     * 统计商品数量
     * @param goodsEntity
     * @return
     */
    int countgoodsName(GoodsEntity goodsEntity);
    /**
     * 新增商品
     * @param goodsEntity
     * @return
     */
    int addGoods(GoodsEntity goodsEntity);
    /**
     * 删除商品信息
     * @param  listCode 选中商品号集合
     * @return
     */
    int deleteGoods(@Param("listCode") List<String> listCode, @Param("goodsId") String goodsId);

    /**
     * 按商品编号统计商品编号
     * @param
     * @return
     */
    int countgoods(String goodsCode);
    /**
     * 查询商品详情信息
     * @param goodsCode
     * @return 修改结果
     */
    GoodsEntity queryGoodDetail(@Param("goodsCode")String goodsCode);

    /**
     * 按实体统计商品名称
     * @param
     * @return
     */
    int countGoodsEntity(GoodsEntity goodsEntity);

    /**
     * 修改商品信息
     * @param goodsEntity 商品信息
     * @return 修改结果
     */
    int updateGoods(GoodsEntity goodsEntity) ;

    /**
     * 统计商品名字
     * @param goodsEntity
     * @return
     */
    int updateGoodsauthorname(GoodsEntity goodsEntity);

    /**
     * 修改商品状态
     * @param  listCode 选中商品编号集合
     * @return
     */
    int  upperOrLowerShelf(@Param("listCode") List<String> listCode, @Param("skuState") int skuState);

    /**
     * 商品列表信息分页查询
     * @param goodsEntity 商品信息
     * @return
     */
    List<GoodsEntity>listGoods(GoodsEntity goodsEntity);
}

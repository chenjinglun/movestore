package com.example.demo.Rota.Dao;

import com.example.demo.Rota.Entity.RotaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface RotaDao {
    /**
     * 新增轮播图
     * @param rotaEntity
     * @return
     */
    int addRotaChart(RotaEntity rotaEntity);
    /**
     * 删除轮播图
     * @param bannerCode
     * @param RotaId
     * @return
     */
    int deleteRotaChart(@Param("listCode") List<String> listCode, @Param("RotaId") String RotaId);
    /**
     * 查询轮播图列表
     * @param carouserlInfo
     * @return
     */
    List<RotaEntity>queryRotaChartList(RotaEntity rotaEntity);
    /**
     * 修改轮播图状态
     * @param  listCode 选中商品编号集合
     * @return
     */
    int updateRotaChartState(@Param("listCode") List<String> listCode, @Param("imageState") String imageState);
    /**
     * 商品列表信息分页查询
     * @param goodsEntity 商品信息
     * @return
     */
    List<RotaEntity>goods(RotaEntity rotaEntity);


}

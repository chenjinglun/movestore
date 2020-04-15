package com.example.demo.Province.Dao;

import com.example.demo.Province.Entity.AreaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaDao {
    /**
     * 获取所以省份
     * @param AreaEntity 省份信息
     * @return
     */
    List<AreaEntity>queryProvince(AreaEntity areaEntity);

    /**
     * 获取所在省 的市
     * @param dictCode 父级编码
     * @return
     */
    List<Integer>queryCity(int dictCode);

    /**
     * 获取所在市的区/县
     * @param dictCode 父级编码
     * @return
     */
    List<Integer>queryCounty(int dictCode);
}

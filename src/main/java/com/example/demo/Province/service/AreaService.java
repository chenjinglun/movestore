package com.example.demo.Province.service;

import com.example.demo.Province.Dao.AreaDao;
import com.example.demo.Province.Entity.AreaEntity;
import com.example.demo.util.ResponceData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AreaService {
    private ResponceData responceData;
    @Resource
    private AreaDao areaDao;

    /**
     * 查询所有省份
     * @param areaEntity
     * @return
     * @Author scout
     * @Date 2020年4月7日09:59:41
     */
    public ResponceData queryProvince(AreaEntity areaEntity) {
        PageHelper.startPage(areaEntity.getPageNum(), areaEntity.getPageSize());
        List<AreaEntity> AreaList= areaDao.queryProvince(areaEntity);
        // 包装Page对象
        PageInfo<AreaEntity> pageData = new PageInfo<>(AreaList);
        return ResponceData.success("查询成功！",pageData);
    }

    /**
     * 查询所属省的市
     * @param dictCode 省编码
     * @return
     * @Author scout
     * @Date 2020年4月7日09:59:41
     */
    public ResponceData queryCity(int dictCode) {
        List<Integer> AreaList= areaDao.queryCity(dictCode);
        // 包装Page对象
        PageInfo<Integer> pageData = new PageInfo<>(AreaList);
        return ResponceData.success("查询成功！",pageData);
    }
    /**
     * 查询所属市的区/县
     * @param dictCode 市编码
     * @return
     * @Author scout
     * @Date 2020年4月7日09:59:41
     */
    public ResponceData queryCounty(int dictCode) {
        List<Integer> AreaList= areaDao.queryCounty(dictCode);
        // 包装Page对象
        PageInfo<Integer> pageData = new PageInfo<>(AreaList);
        return ResponceData.success("查询成功！",pageData);
    }


}

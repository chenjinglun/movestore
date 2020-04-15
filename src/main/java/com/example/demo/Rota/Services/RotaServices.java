package com.example.demo.Rota.Services;

import com.example.demo.Rota.Dao.RotaDao;
import com.example.demo.Rota.Entity.RotaEntity;
import com.example.demo.util.ResponceData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static com.example.demo.util.AuthUtils.generateMixString;

@Service
public class RotaServices {
    @Resource
    private RotaDao rotaDao;

    /**
     * 新增商品
     * @param rotaEntity
     * @return goodsEntity
     * @Author scout
     * @Date s42020年4月12日
     */

    @Transactional(rollbackFor = Exception.class)
    public ResponceData addRotaChart(RotaEntity rotaEntity) {
        rotaEntity.setBannerCode(generateMixString(3));
        rotaEntity.setIs_deleted(0);
        //新增轮播图
        int count = rotaDao.addRotaChart(rotaEntity);
        if (0 == count) {
            return ResponceData.bizError("轮播图新增失败，请重试");
        }
        return ResponceData.success("轮播图新增成功！");
    }

    /**
     * 删除轮播图
     * @param bannerCode
     * @param lastModifiedBy
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteRotaChart(String bannerCode,String RotaId){
        List<String> listCode = Arrays.asList(bannerCode.split(","));
        int count=rotaDao.deleteRotaChart(listCode,RotaId);
        if(0==count){
            return ResponceData.bizError("轮播图删除失败，请重试");
        }
        return ResponceData.success("轮播图删除成功");
    }

    /**
     * 分页查询轮播图
     * @param rotaEntity
     * @return
     */

    public ResponceData queryRotaChartList(RotaEntity rotaEntity){
        PageHelper.startPage(rotaEntity.getPageNum(), rotaEntity.getPageSize());
        List<RotaEntity> rotaList= rotaDao.queryRotaChartList(rotaEntity);
        // 包装Page对象
        PageInfo<RotaEntity> pageData = new PageInfo<>(rotaList);
        return ResponceData.success("查询成功！",pageData);

    }

    /**
     * 修改轮播图状态
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月12日
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateRotaChartState(String bannerCode,String imageState){
        int j=0;
        List<String> listCode = Arrays.asList(bannerCode.split(","));
        for(String str : listCode){
            j++;
        }
        ResponceData response = ResponceData.success("商品状态修改成功");
        //修改商品状态
        int count = rotaDao.updateRotaChartState(listCode,imageState);
        if (j != count) {
            response = ResponceData.bizError("商品状态修改失败，请重试！");
        }
        return response;

    }

    /**
     * 查询商品列表（分页）
     * @param customerEntity
     * @return
     * @Author scout
     * @Date 2020-4-1
     */
    public ResponceData goods(RotaEntity rotaEntity) {
        PageHelper.startPage(rotaEntity.getPageNum(), rotaEntity.getPageSize());
        List<RotaEntity> rotaList= rotaDao.goods(rotaEntity);
        // 包装Page对象
        PageInfo<RotaEntity> pageData = new PageInfo<>(rotaList);
        return ResponceData.success("查询成功！",pageData);
    }
}

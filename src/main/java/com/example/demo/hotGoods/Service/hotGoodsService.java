package com.example.demo.hotGoods.Service;

import com.example.demo.hotGoods.Dao.hotGoodsDao;
import com.example.demo.hotGoods.Entity.hotGoodsEntity;
import com.example.demo.hotGoods.Entity.hotGoodsShowNum;
import com.example.demo.hotGoods.Entity.hotGoodslistEntity;
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
public class hotGoodsService {
    @Resource
    private hotGoodsDao hotGoodsDao;

    /**
     * 新增热门商品
     * @param hotGoodsEntity
     * @return hotGoodsEntity
     * @Author scout
     * @Date 2020年4月14日
     */

    @Transactional(rollbackFor = Exception.class)
    public ResponceData addHotGood(hotGoodsEntity hotGoodsEntity) {
        //商品是否存在
        int countgoosCode = hotGoodsDao.counthotgoodsCode(hotGoodsEntity);
        int countSort = hotGoodsDao.countSort(hotGoodsEntity);
        if (0 != countgoosCode) {
            return ResponceData.bizError("热门商品已存在，请重新输入");
        }
        if (0 != countSort) {
            return ResponceData.bizError("热门商品排序已存在，请重新输入");
        }
        hotGoodsEntity.setProductPop(generateMixString(3));
        hotGoodsEntity.setIs_deleted(0);
        //新增商品
        int count = hotGoodsDao.addHotGood(hotGoodsEntity);
        if (0 == count) {
            return ResponceData.bizError("热门商品新增失败，请重试");
        }
        return ResponceData.success("热门商品新增成功！");
    }

    /**
     * 删除热门商品
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月8日11:06:56
     */
    @Transactional(rollbackFor = Exception.class)
    public  ResponceData deleteHotGood(String productPop,String hootGoodsId){
        List<String> listCode = Arrays.asList(productPop.split(","));
        ResponceData response = ResponceData.success("热门商品删除成功");
        //删除热门商品
        int count = hotGoodsDao.deleteHotGood(listCode, hootGoodsId);
        if (0 == count) {
            response = ResponceData.bizError("商品删除失败，请重试！");
        }
        return response;

    }

    /**
     * 修改热门商品信息
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月14日
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateHotGood(hotGoodsEntity hotGoodsEntity) {
        ResponceData response = ResponceData.success("商品信息修改成功");
        int countgoosCode = hotGoodsDao.counthotgoodsCode(hotGoodsEntity);
        int countSort = hotGoodsDao.countSort(hotGoodsEntity);
        if (0 != countgoosCode) {
            return ResponceData.bizError("热门商品已存在，请重新输入");
        }
        if (0 != countSort) {
            return ResponceData.bizError("热门商品排序已存在，请重新输入");
        }
        int count = hotGoodsDao.updateHotGood(hotGoodsEntity);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }

    /**
     * 查询热门商品详情
     * @param
     * @return StoreInEntity
     * @Author scout
     * @Date 2020年4月8日
     */
    public ResponceData queryHotGoodDetail(String productPop){
        hotGoodsEntity hotGoodsEntity = hotGoodsDao.queryHotGoodDetail(productPop);
        return ResponceData.success("查询成功", hotGoodsEntity);
    }

    /**
     * 查询热门商品列表（分页）
     * @param hotGoodslistEntity
     * @Author scout
     * @Date 2020年4月14日
     */
    public ResponceData queryHotGoodsList(hotGoodslistEntity hotGoodslistEntity) {
        PageHelper.startPage(hotGoodslistEntity.getPageNum(),hotGoodslistEntity.getPageSize());
        List<hotGoodslistEntity> goodsList= hotGoodsDao.queryHotGoodsList(hotGoodslistEntity);
        // 包装Page对象
        PageInfo<hotGoodslistEntity> pageData = new PageInfo<>(goodsList);
        return ResponceData.success("查询成功！",pageData);
    }

    /**
     * 查询商品信息
     * @param
     * @return StoreInEntity
     * @Author scout
     * @Date 2020年4月8日
     */
    public ResponceData showHotGoodsNum(hotGoodsShowNum hotGoodsShowNum){
        hotGoodsShowNum hotGoodsShowNum1 = hotGoodsDao.showHotGoodsNum(hotGoodsShowNum);
        return ResponceData.success("查询成功", hotGoodsShowNum1);
    }

    /**
     * 修改热门商品展示数量
     * @param showNum
     * @Author scout
     * @Date 2020年4月14日18
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateHotGoodsNum(hotGoodsShowNum hotGoodsShowNum) {
        ResponceData response = ResponceData.success("商品展示数量修改成功");
        int count = hotGoodsDao.updateHotGoodsNum(hotGoodsShowNum);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }

}

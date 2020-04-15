package com.example.demo.goods.services;

import com.example.demo.goods.dao.GoodsDao;
import com.example.demo.goods.entity.GoodsEntity;
import com.example.demo.util.ResponceData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.demo.util.AuthUtils.generateMixString;

@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 新增商品
     * @param goodsEntity
     * @return goodsEntity
     * @Author scout
     * @Date s42020年4月12日
     */

    @Transactional(rollbackFor = Exception.class)
    public ResponceData addGoods(GoodsEntity goodsEntity) {
        //商品是否存在
        int countgoosName = goodsDao.countgoodsName(goodsEntity);
        if (0 != countgoosName) {
            return ResponceData.bizError("商品已存在，请重新输入");
        }
        goodsEntity.setGoodsCode(generateMixString(6));
        goodsEntity.setIs_deleted(0);
        //新增商品
        int count = goodsDao.addGoods(goodsEntity);
        if (0 == count) {
            return ResponceData.bizError("商品新增失败，请重试");
        }
        return ResponceData.success("商品新增成功！");
    }

    /**
     * 删除商品
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月8日11:06:56
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteGoods(String goodsCode,String goodsId){
        //System.out.println(menuCode+","+menuId);
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        ResponceData response = ResponceData.success("商品删除成功");
        //删除菜单
        int count = goodsDao.deleteGoods(listCode, goodsId);
        //demoDao.deleteUser(listCode,userId);
        if (0 == count) {
            response = ResponceData.bizError("商品删除失败，请重试！");
        }
        return response;

    }

    /**
     * 查询商品信息
     * @param
     * @return StoreInEntity
     * @Author scout
     * @Date 2020年4月8日
     */
    public ResponceData queryGoodDetail(String goodsCode){
        GoodsEntity goodsEntity = goodsDao.queryGoodDetail(goodsCode);
        int countgoodsNo = goodsDao.countgoods(goodsCode);
        if (0 == countgoodsNo) {
            return ResponceData.bizError("商品已删除，请重新输入");
        }
        return ResponceData.success("查询成功", goodsEntity);
    }

    /**
     * 修改商品信息
     * @param
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateGoods(GoodsEntity goodsEntity) {
        ResponceData response = ResponceData.success("商品信息修改成功");
        //检验账号是否存在
        int countStore = goodsDao.countGoodsEntity(goodsEntity);
        int countStores = goodsDao.updateGoodsauthorname(goodsEntity);
        if (0 != countStore && 0 != countStores ) {
            return ResponceData.bizError("商品已存在，请重新输入！");
        }
        int count = goodsDao.updateGoods(goodsEntity);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }

    /**
     * 修改商品状态
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月8日11:06:56
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData upperOrLowerShelf(String goodsCode,int skuState){
        int j=0;
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        for(String str : listCode){
            j++;
        }
        ResponceData response = ResponceData.success("商品状态修改成功");
        //修改商品状态
        int count = goodsDao.upperOrLowerShelf(listCode,skuState);
        if (j != count) {
            response = ResponceData.bizError("商品状态修改失败，请重试！");
        }
        return response;

    }
    /**
     * 查询商品列表（分页）
     * @param goodsEntity
     * @return
     * @Author scout
     * @Date 2020-4-1
     */
    public ResponceData listGoods(GoodsEntity goodsEntity) {
        PageHelper.startPage(goodsEntity.getPageNum(), goodsEntity.getPageSize());
        List<GoodsEntity> goodsList= goodsDao.listGoods(goodsEntity);
        // 包装Page对象
        PageInfo<GoodsEntity> pageData = new PageInfo<>(goodsList);
        return ResponceData.success("查询成功！",pageData);
    }
}

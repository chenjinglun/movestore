package com.example.demo.goodTypeManger.Service;

import com.example.demo.goodTypeManger.Entity.goodMangerEntity;
import com.example.demo.goodTypeManger.Dao.goodMangerDao;
import com.example.demo.util.ResponceData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.demo.util.AuthUtils.generateMixString;

@Service
public class goodMangerService {

    private ResponceData responceData;
    @Resource
    private goodMangerDao goodMangerDao;


    /**
     * 新增一级分类
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月7日09:59:41
     */


    @Transactional(rollbackFor = Exception.class)
    public ResponceData addFirstClass(goodMangerEntity goodMangerEntity) {
        //分类名称是否存在
        int counttypemanger = goodMangerDao.counttypemanger(goodMangerEntity);
        if (0 != counttypemanger) {
            return ResponceData.bizError("分类已存在，请重新输入");
        }
        goodMangerEntity.setIs_deleted(0);
        goodMangerEntity.setCateCode(generateMixString(6));
        //新增门店
        int count = goodMangerDao.addFirstClass(goodMangerEntity);
        if (0 == count) {
            return ResponceData.bizError("一级分类新增失败，请重试");
        }
        return ResponceData.success("一级分类新增成功！");
    }

    /**
     * 新增二级分类
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月7日09:59:41
     */

    @Transactional(rollbackFor = Exception.class)
    public ResponceData addSecondClass(goodMangerEntity goodMangerEntity) {
        //分类名称是否存在
        int countsecondtypemanger = goodMangerDao.counttypemanger(goodMangerEntity);
        if (0 != countsecondtypemanger) {
            return ResponceData.bizError("分类已存在，请重新输入");
        }
        goodMangerEntity.setIs_deleted(0);
        goodMangerEntity.setCateCode(generateMixString(6));
        //新增二级分类
        int count = goodMangerDao.addSecondClass(goodMangerEntity);
        if (0 == count) {
            return ResponceData.bizError("二级分类新增失败，请重试");
        }
        return ResponceData.success("二级分类新增成功！");
    }

    /**
     * 删除分类
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月10日
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteGoodClass(String cateCode){
        ResponceData response = ResponceData.success("分类删除成功");
        //删除分类
        int count = goodMangerDao.deleteGoodClass(cateCode);
        if (0 == count) {
            response = ResponceData.bizError("分类删除失败，请重试！");
        }
        return response;
    }

    /**
     * 修改司机信息
     * @param
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateGoodClass(goodMangerEntity goodMangerEntity) {
        ResponceData response = ResponceData.success("修改分类信息成功");
        //分类名称是否存在
        int countName = goodMangerDao.counttypemanger(goodMangerEntity);
        if (0 != countName) {
            return ResponceData.bizError("分类名称已存在，请重新输入");
        }
        int count = goodMangerDao.updateGoodClass(goodMangerEntity);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }

    /**
     * 查询分类信息
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月8日
     */
    public ResponceData queryGoodClass(String cateCode){
        goodMangerEntity goodMangerEntity = goodMangerDao.queryGoodClass(cateCode);

        int countTypes = goodMangerDao.countType(cateCode);
        if (0 == countTypes) {
            return ResponceData.bizError("分类不存在，请重新输入");
        }
        return ResponceData.success("查询成功", goodMangerEntity);
    }

    /**
     * 查询分类信息
     * @param goodMangerEntity
     * @return goodMangerEntity
     * @Author scout
     * @Date 2020年4月10日
     */
    public ResponceData queryGoodClassList1(goodMangerEntity goodMangerEntity) {

        List<goodMangerEntity> goodTypeList= goodMangerDao.queryGoodClassList1(goodMangerEntity);
        return ResponceData.success("查询成功！",goodTypeList);
    }

    /**
     * 查询分类信息
     * @param goodMangerEntity
     * @return goodMangerEntity
     * @Author scout
     * @Date 2020年4月10日
     */
    public ResponceData queryGoodClassList2(String cateCode) {

        List<Integer> goodTypeList2= goodMangerDao.queryGoodClassList2(cateCode);
        return ResponceData.success("查询成功！",goodTypeList2);
    }
}

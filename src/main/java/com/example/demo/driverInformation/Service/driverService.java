package com.example.demo.driverInformation.Service;

import com.example.demo.driverInformation.Dao.driverDao;
import com.example.demo.driverInformation.Entity.driverEntity;
import com.example.demo.util.ResponceData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class driverService {
    private ResponceData responceData;
    @Resource
    private driverDao driverDao;

    @Transactional(rollbackFor = Exception.class)
    public ResponceData addDrive(driverEntity driverEntity) {
        //用户是否存在
        int countUserAcct = driverDao.countUserAcct(driverEntity);
        if (0 != countUserAcct) {
            return ResponceData.bizError("用户已存在，请重新输入");
        }

        //身份证是否一致
        int countIdentify = driverDao.countIdentify(driverEntity);
        if (0 != countIdentify) {
            return ResponceData.bizError("身份证已存在，请重新输入");
        }

        //手机号是否一致
        int countPhone = driverDao.countPhone(driverEntity);
        if (0 != countPhone) {
            return ResponceData.bizError("手机号已存在，请重新输入");
        }

        driverEntity.setIs_deleted(0);
        //新增门店
        int count = driverDao.addDrive(driverEntity);
        if (0 == count) {
            return ResponceData.bizError("司机新增失败，请重试");
        }
        return ResponceData.success("司机新增成功！");
    }

    /**
     * 删除门店
     * @param
     * @return
     * @Author scout
     * @Date 2020年4月8日11:06:56
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData deleteDriver(String driverCode,String driverID){
        List<String> listCode = Arrays.asList(driverCode.split(","));
        List<Integer> listCode2 = new ArrayList<>();
        for(String str : listCode){
            int i = Integer.parseInt(str);
            listCode2.add(i);
        }
        ResponceData response = ResponceData.success("司机信息删除成功");
        //删除菜单
        int count = driverDao.deleteDriver(listCode2, driverID);
        //demoDao.deleteUser(listCode,userId);
        if (0 == count) {
            response = ResponceData.bizError("司机信息删除失败，请重试！");
        }
        return response;
    }

    /**
     * 司机信息详情
     * @param
     * @return StoreInEntity
     * @Author scout
     * @Date 2020年4月8日
     */
    public ResponceData queryDriverDetail(int driverNo){
        driverEntity driverEntity = driverDao.queryDriverDetail(driverNo);
        //int countstoreNo = storeInDao.countStore(storeNO);
        //System.out.println(countstoreNo+"--------------------------");
//        if (0 == countstoreNo) {
//            return ResponceData.bizError("门店已删除，请重新输入");
//        }
        return ResponceData.success("查询成功", driverEntity);
    }

    /**
     * 修改司机信息
     * @param
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateDriver(driverEntity driverEntity) {
        ResponceData response = ResponceData.success("修改成功");
        //检验账号是否存在
        int countUserAcct = driverDao.countUserAcct(driverEntity);
        int countdriverAccts = driverDao.countdriverAcct(driverEntity);
        if (0 != countUserAcct || countdriverAccts != 0) {
            return ResponceData.bizError("账号已存在，请重新输入");
        }

        //身份证是否一致
        int countIdentify = driverDao.countIdentify(driverEntity);
        int countIdentifys = driverDao.countdriverIdentify(driverEntity);
        if (0 != countIdentify || countIdentifys != 0) {
            return ResponceData.bizError("身份证已存在，请重新输入");
        }

        //手机号是否一致
        int countPhone = driverDao.countPhone(driverEntity);
        int countPhones = driverDao.countdriverPhone(driverEntity);
        if (0 != countPhone || countPhones != 0) {
            return ResponceData.bizError("手机号已存在，请重新输入");
        }

//        int countdriver = driverDao.countdriverEntity(driverEntity);
//        if (0 != countdriver) {
//            return ResponceData.bizError("司机编号已存在，请重新输入");
//        }

        int count = driverDao.updateDriver(driverEntity);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }

    /**
     * 查询司机信息列表（分页）
     * @param customerEntity
     * @return
     * @Author scout
     * @Date 2020-4-1
     */
    public ResponceData queryDriversList(driverEntity driverEntity) {
        PageHelper.startPage(driverEntity.getPageNum(), driverEntity.getPageSize());
        List<driverEntity> driverrList= driverDao.queryDriversList(driverEntity);
        // 包装Page对象
        PageInfo<driverEntity> pageData = new PageInfo<>(driverrList);
        return ResponceData.success("查询成功！",pageData);
    }
}

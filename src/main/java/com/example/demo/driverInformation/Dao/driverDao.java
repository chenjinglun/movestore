package com.example.demo.driverInformation.Dao;

import com.example.demo.driverInformation.Entity.driverEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface driverDao {
    /**
     * 新增门店
     * @param
     * @return
     */
    int addDrive(driverEntity driverEntity);

    /**
     * 统计用户账号数量
     * @param
     * @return
     */

    int countUserAcct(driverEntity driverEntity);
    int countdriverAcct(driverEntity driverEntity);

    /**
     * 统计身份证数量
     * @param
     * @return
     */

    int countIdentify(driverEntity driverEntity);
    int countdriverIdentify(driverEntity driverEntity);

    /**
     * 统计电话数量
     * @param
     * @return
     */
    int countPhone(driverEntity driverEntity);
    int countdriverPhone(driverEntity driverEntity);


    /**
     * 删除司机信息
     * @param  listCode2 选中菜单编号集合
     * @return
     */
    int deleteDriver(@Param("listCode2") List<Integer> listCode2, @Param("driverID") String driverID);

    /**
     * 查询司机信息查询
     * @param
     * @return 修改结果
     */
    driverEntity queryDriverDetail(@Param("driverNo")int driverNo);

    /**
     * 修改司机信息
     * @param
     * @return 修改结果
     */
    int updateDriver(driverEntity driverEntity) ;

    /**
     * 按实体统计司机编号
     * @param
     * @return
     */
    int countdriverEntity(driverEntity driverEntity);

    /**
     * 获取所有司机信息
     * @param driverEntity 司机信息
     * @return
     */
    List<driverEntity>queryDriversList(driverEntity driverEntity);
}

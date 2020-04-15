package com.example.demo.menu.Dao;

//import com.example.demo.MQ.QueueEntity;
import com.example.demo.menu.Entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuDao {
    /**
     * 新增菜单
     * @param  menuEntity 菜单信息
     * @return
     */
    int addMenu(MenuEntity menuEntity);

    /**
     * 统计菜单数量
     * @param
     * @return
     */
    int countMenuAcct(MenuEntity menuEntity);
    /**
     * 删除菜单信息
     * @param  listCode2 选中菜单编号集合
     * @return
     */

    int deletemenu(@Param("listCode2") List<Integer> listCode2, @Param("menuId") String menuId);

    /**
     * 查询菜单信息
     * @param menuNO 菜单编号
     * @return 修改结果
     */
    MenuEntity queryMenuDetail(@Param("menuNO")int menuNO);

    /**
     * 修改菜单
     * @param menuEntity 菜单信息
     * @return 修改结果
     */
    int updateMenu(MenuEntity menuEntity) ;

    /**
     * 获取所有菜单
     * @param
     * @return 菜单名字
     */

    List<String>listMenus(String menuName);

    /**
     * mq
     */
    //int insertToActiveMq(QueueEntity queueEntity);
}

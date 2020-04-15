package com.example.demo.menu.Service;

//import com.alibaba.fastjson.JSON;
import com.example.demo.menu.Dao.MenuDao;
import com.example.demo.menu.Entity.MenuEntity;
import com.example.demo.util.ResponceData;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import com.example.demo.MQ.QueueListen;

import javax.annotation.Resource;
//import javax.jms.Destination;
//import javax.jms.Queue;
//import javax.jms.Topic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Menuservice {
    /*
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired

    private Topic topic;
*/
    private ResponceData responceData;
    @Resource
    private MenuDao menuDao;

    /**
     * 新增菜单
     * @param menuEntity
     * @return
     */

    /*@Transactional(rollbackFor = Exception.class)
    public ResponceData addMenu(MenuEntity menuEntity){
        int countmenu = menuDao.countMenuAcct(menuEntity);
        if (0 != countmenu) {
            return ResponceData.bizError("菜单已存在，请重新输入");
        }
        menuEntity.setIs_deleted(0);
        int count = menuDao.addMenu(menuEntity);
        if (0 != count) {
            String dataSet = JSON.toJSONString(menuEntity);
            sendMessage(queue,dataSet);
            return ResponceData.success("新增成功！");
        }
        return ResponceData.bizError("新增失败，请重试");
    }
    private void sendMessage(Destination QueueListen, final String message){
        jmsMessagingTemplate.convertAndSend(QueueListen, message);
    }*/

    @Transactional(rollbackFor = Exception.class)
    public ResponceData addMenu(MenuEntity menuEntity){
        int countmenu = menuDao.countMenuAcct(menuEntity);
        if (0 != countmenu) {
            return ResponceData.bizError("菜单已存在，请重新输入");
        }
        menuEntity.setIs_deleted(0);
        int count = menuDao.addMenu(menuEntity);
        if (0 != count) {
        return ResponceData.success("新增成功！");
        }
        return ResponceData.bizError("新增失败，请重试");
    }


    /**
     * 查询菜单
     * @param
     * @return menuEntity
     * @Author scout
     * @Date 2020-03-25
     */
    public ResponceData queryMenuDetail(int menuNO) {
        MenuEntity menuEntity = menuDao.queryMenuDetail(menuNO);
        int countmenu = menuDao.countMenuAcct(menuEntity);
        if (0 == countmenu) {
            return ResponceData.bizError("菜单已删除，请重新输入");
        }
        return ResponceData.success("查询成功", menuEntity);

    }
    /**
 * 删除用户
 * @param
 * @return
 * @Author scout
 * @Date 2020-03-25
 */
        @Transactional(rollbackFor = Exception.class)
        public ResponceData deletemenu (String menuCode, String menuId){
            System.out.println(menuCode+","+menuId);
            List<String> listCode = Arrays.asList(menuCode.split(","));
            List<Integer> listCode2 = new ArrayList<>();
            for(String str : listCode){
                System.out.println(str);
                int i = Integer.parseInt(str);
                listCode2.add(i);
            }
            ResponceData response = ResponceData.success("删除成功");
            //删除菜单
            int count = menuDao.deletemenu(listCode2, menuId);
            //demoDao.deleteUser(listCode,userId);
            if (0 == count) {
                response = ResponceData.bizError("删除失败，请重试！");
            }
            return response;

    }
    /**
     * 修改菜单
     * @param menu
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponceData updateMenu(MenuEntity menuEntity) {
        ResponceData response = ResponceData.success("修改成功");
        //检验账号是否存在
        int countMenuAcct = menuDao.countMenuAcct(menuEntity);
        if (0 != countMenuAcct) {
            return ResponceData.bizError("用户已存在，请重新输入！");
        }
        int count = menuDao.updateMenu( menuEntity);
        if (0 == count) {
            response = ResponceData.versionError("数据变化，请重新刷新");
            return response;
        }
        return response;
    }

    /**
     * 菜单列表查询
     * @param menuEntity
     * @return
     * @Author scout
     * @Date 2020-03-25
     */
    public ResponceData listMenus(String menuName){
        List<String> menuList = menuDao.listMenus(menuName);
        return ResponceData.success("查询成功！",menuList);
    }

}

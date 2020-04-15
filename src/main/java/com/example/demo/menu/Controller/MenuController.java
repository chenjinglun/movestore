package com.example.demo.menu.Controller;

import com.example.demo.menu.Entity.MenuEntity;
import com.example.demo.menu.Service.Menuservice;
import com.example.demo.util.AuthUtils;
import com.example.demo.util.ResponceData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/*@SpringBootApplication
@EnableTransactionManagement
@EnableJms*/

@RestController
@RequestMapping("/Menu")
public class MenuController {
//    public static void main(String[] agrgs){
//        SpringApplication.run(MenuController.class,agrgs);
//    }
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    private Menuservice menuservice;

    /**
     * demo 新增菜单
     *
     * @param
     * @return AppResponse
     * @author scout
     * @Date 2020-03-31.
     */
    @PostMapping("addMenu")
    public ResponceData addMenu(MenuEntity menuEntity){
        try{
        ResponceData menuRespond = menuservice.addMenu(menuEntity);
        return  menuRespond;
    }catch (Exception e){
        logger.error("菜单新增失败",e);
        System.out.println(e.toString());
        throw  e;
    }
    }

    /**
     * 查询菜单
     * @param
     * @return AppResponse
     * @author scout
     * @Date 2020-03-31.
     */
    @PostMapping("queryMenuDetail")
    public ResponceData queryMenuDetail(int menuNO){
        try {
            return menuservice.queryMenuDetail(menuNO);
        } catch (Exception e) {
            logger.error("用户查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     * @param
     * @return AppResponse
     * @author scout
     * @Date 2020-03-31.
     */
    @PostMapping("deletemenu")
    public ResponceData deletemenu(HttpServletRequest httpServletRequest){
        String menuCode = httpServletRequest.getParameter("listCode");

        try{
            String menuID = AuthUtils.getCurrentUmenuId();
            return  menuservice.deletemenu(menuCode,menuID);
        }catch (Exception e){
            logger.error("菜单删除失败",e);
            System.out.println(e.toString());
            throw e; }
    }

    /**
     * 修改菜单
     * @param updateMenu
     * @return Response
     * @author scout
     * @Date 2020-03-25
     */
    @PostMapping("updateMenu")
    public ResponceData updateMenu(MenuEntity menuEntity){
        try{
            //获取用户id
            String menuId = AuthUtils.getCurrentUmenuId();
            menuEntity.setCreate_by(menuId);
            menuEntity.setLast_modified_by(menuId);
            return menuservice.updateMenu(menuEntity);
        }catch (Exception e){
            logger.error("修改菜单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 菜单列表查询
     * @param
     * @return Response
     * @author scout
     * @Date 2020-03-25
     */
    @PostMapping("listMenus")
    public ResponceData listMenus(String menuName){
        try{
            return menuservice.listMenus(menuName);
        }catch (Exception e){
            logger.error("用户查询错误");
            System.out.println(e.toString());
            throw e;
        }
    }

}

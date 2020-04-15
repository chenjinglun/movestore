package com.example.demo.register.Service;

import com.example.demo.register.Dao.registerDao;
import com.example.demo.register.Entity.registerEntity;
import com.example.demo.util.ResponceData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.example.demo.util.AuthUtils.generateMixString;

@Service
public class registerService {
    private ResponceData responceData;
    @Resource
    private registerDao registerDao;

    /**
     * 注册新增用户
     * @param registerEntity
     * @return
     * @Author scout
     * @Date 2020年4月15日
     */


    @Transactional(rollbackFor = Exception.class)
    public ResponceData addUser(registerEntity registerEntity) {
        //账号是否存在
        int countAcct = registerDao.countAcct(registerEntity);
        if (0 != countAcct) {
            return ResponceData.bizError("用户已存在，请重新输入");
        }
        registerEntity.setIs_deleted(0);
        registerEntity.setUserCode(generateMixString(4));
        //新增用户
        int count = registerDao.addUser(registerEntity);
        if (0 == count) {
            return ResponceData.bizError("新增失败，请重试");
        }
        return ResponceData.success("新增成功！");
    }
}

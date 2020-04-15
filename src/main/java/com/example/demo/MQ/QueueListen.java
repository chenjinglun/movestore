/*package com.example.demo.MQ;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.menu.Dao.MenuDao;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class QueueListen {
    @Resource
    MenuDao menuDao;
    @JmsListener(destination = "${spring.jms.queue-name}",containerFactory="queueListener")
    public void readActiveQueue(String message){
        int i=1;
        JSONObject jsonObject = JSONObject.parseObject(message);
        QueueEntity queueEntity;
        queueEntity=(QueueEntity) JSONObject.toJavaObject(jsonObject,QueueEntity.class);
        queueEntity.setMQcode(++i);
        queueEntity.setContent(message);
        int result = menuDao.insertToActiveMq(queueEntity);
        if(result>0){
            System.out.println("Queue收到"+message);
        }

    }
}
*/
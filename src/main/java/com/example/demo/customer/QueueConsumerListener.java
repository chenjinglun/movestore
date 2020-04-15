/*package com.example.demo.customer;

import com.example.demo.menu.Dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class QueueConsumerListener {

    //queue模式的消费者
    @JmsListener(destination="${spring.jms.queue-name}", containerFactory="queueListener")
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }

    @Component
    public static class TopicConsumerListener {

        //topic模式的消费者
        @JmsListener(destination="${spring.jms.topic-name}", containerFactory="topicListener")
        public void readActiveQueue(String message) {


            //
            System.out.println("topic接受到：" + message);
        }
    }
}*/

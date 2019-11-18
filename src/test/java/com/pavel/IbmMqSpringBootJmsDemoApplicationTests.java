package com.pavel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IbmMqSpringBootJmsDemoApplicationTests {

    @Autowired
    private JmsOperations jmsOperations;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendMsg() {
        // replace first param with the queue name
        jmsOperations.convertAndSend("DEV.QUEUE.1", "hello world");
    }

    @Test
    public void receiveMsg() {
        // replace first param with the queue name
        jmsOperations.receiveAndConvert("DEV.QUEUE.1");
    }

    @Test
    @Transactional(value = "jmsTransactionManager")
    public void transaction() {
        // replace first param with the queue name
        jmsOperations.convertAndSend("DEV.QUEUE.1", "transaction test");
    }


}

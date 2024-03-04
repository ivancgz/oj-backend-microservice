package com.ivan.cojbackendjudgeservice.message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 用于创建测试程序用到的交换机和队列 (只用在程序启动前执行一次)
 */
@Slf4j
public class InitRabbitMQ {

    public static void doInit() {
        try {
            // 创建连接
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            // 创建消息队列的客户端
            Channel channel = connection.createChannel();
            // 创建一个交换机, 用来转发消息
            String EXCHANGE_NAME = "code_exchange";
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            // 创建队列，随机分配一个队列名称, 用来收消息和发消息
            String queueName = "code_queue";
            channel.queueDeclare(queueName, true, false, false, null);
            // 执行一个路由键
            channel.queueBind(queueName, EXCHANGE_NAME, "my_routingKey");
            log.info("消息队列启动成功");
        } catch (IOException | TimeoutException e) {
            log.error("消息队列启动失败");
        }
    }

    public static void main(String[] args) {
        doInit();
    }
}

package com.yingu.project.big.data.jms;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.task.TaskExecutor;


/**
 * @author huangkunhao
 * @description rabbitmq配置
 */
@Configuration
public class RabbitMqConfig {
    @Autowired
    Environment environment;

    /**
     * 交换机 支付
     */
    public static final String TOPIC_EXCHANGE_PUHUI = "te-pgw-online";
    /**
     * 信审 交换机
     */
    public static final String TOPIC_EXCHANGE_AUDIT = "car_loan_exchange";


    /**
     * 路由key  支付
     */
    public static final String ROUTINGKEY_BINDCARD_REQUEST = "pgw.rq.online";
    public static final String ROUTINGKEY_BINDCARD_RESPONSE = "pgw.rs.ygdebit.car.car.direct_bind_card";


    /**
     * 信审  推送给信审
     */
    public static final String ROUTINGKEY_AUDIT_REQUEST = "routing-key:car_loan";
    public static final String ROUTINGKEY_AUDIT_RESPONSE = "rk-car-loan-audit";

    /**
     * 接收队列名称 支付
     */
    public static final String QUEUE_LOAN_RM = "loan-listen-rm";
    public static final String QUEUE_AUDIT = "q-car-loan-rs-audit";

    /**
     * 声明监听工厂  支付
     */
    public static final String LISTENER_PUHUI = "rabbitListenerPuHui";
    public static final String LISTENER_AUDIT = "rabbitListenerAudit";

    /**
     * 连接 支付
     */
    public static final String CONNECTIONFACTORY_PUHUI = "connectionFactoryPuHui";
    // 连接工厂 信审
    public static final String CONNECTIONFACTORY_AUDIT= "connectionFactoryAudit";

    /**
     * Template 支付
     */
    public static final String TEMPLATE_PUHUI = "puHuiTemplate";
    public static final String TEMPLATE_AUDIT = "auditTemplate";


    /**
     * rabbit连接--普惠
     * @return ConnectionFactory
     */
    @Bean(value = CONNECTIONFACTORY_PUHUI)
    @Primary
    public ConnectionFactory connectionFactoryPuHui(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(environment.getProperty("spring.rabbitmq.puhui.host"));
        connectionFactory.setPort(Integer.parseInt(environment.getProperty("spring.rabbitmq.puhui.port")));
        connectionFactory.setVirtualHost(environment.getProperty("spring.rabbitmq.puhui.virtual-host"));
        connectionFactory.setUsername(environment.getProperty("spring.rabbitmq.puhui.username"));
        connectionFactory.setPassword(environment.getProperty("spring.rabbitmq.puhui.password"));
        return connectionFactory;
    }

    /**
     * rabbit连接--信审
     * @return ConnectionFactory
     */
    @Bean(value = CONNECTIONFACTORY_AUDIT)
    public ConnectionFactory connectionFactoryAudit(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(environment.getProperty("spring.rabbitmq.audit.host"));
        connectionFactory.setPort(Integer.parseInt(environment.getProperty("spring.rabbitmq.audit.port")));
        connectionFactory.setVirtualHost(environment.getProperty("spring.rabbitmq.audit.virtual-host"));
        connectionFactory.setUsername(environment.getProperty("spring.rabbitmq.audit.username"));
        connectionFactory.setPassword(environment.getProperty("spring.rabbitmq.audit.password"));
        return connectionFactory;
    }
    /**
     * 声明admin
     * @return RabbitAdmin
     */
    @Bean
    public RabbitAdmin adminPuHui(){
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactoryPuHui());
        return rabbitAdmin;
    }
    @Bean
    public RabbitAdmin adminAudit(){
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactoryAudit());
        return rabbitAdmin;
    }
    /**
     *  声明主题交换机
     * @return TopicExchange
     */
    @Bean
    public TopicExchange exchangePuHui() {
        return new TopicExchange(TOPIC_EXCHANGE_PUHUI, true, false);
    }

    @Bean
    public TopicExchange exchangeAudit() {
        return new TopicExchange(TOPIC_EXCHANGE_AUDIT, true, false);
    }


    @Bean
    public Queue queueAudit() {
        return new Queue(QUEUE_AUDIT, true, false, false);
    }


    /**
     * 声明绑定关系
     * @return Binding
     */

    @Bean
    public Binding bindingAudit(){
        return BindingBuilder.bind(queueAudit()).to(exchangeAudit()).with(ROUTINGKEY_AUDIT_RESPONSE);
    }



    /**
     * 声明监听工厂
     * @return SimpleRabbitListenerContainerFactory
     */
    @Bean(value = LISTENER_PUHUI)
    public SimpleRabbitListenerContainerFactory rabbitListeners(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactoryPuHui());
        //多线程处理队列
        factory.setConcurrentConsumers(3);
        //使用全局线程池
        //  factory.setTaskExecutor(taskExecutor);
        return factory;
    }


    @Bean(value = LISTENER_AUDIT)
    public SimpleRabbitListenerContainerFactory rabbitListenersAudit(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactoryAudit());
        //多线程处理队列
        factory.setConcurrentConsumers(3);
        //使用全局线程池
        //  factory.setTaskExecutor(taskExecutor);
        return factory;
    }




    /**
     *  配置rabbitTemplate
     * @return RabbitTemplate
     */
    @Bean(value = TEMPLATE_PUHUI)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactoryPuHui());
        rabbitTemplate.setExchange(TOPIC_EXCHANGE_PUHUI);

        return rabbitTemplate;
    }

    /**
     *  配置rabbitTemplate
     * @return RabbitTemplate
     */
    @Bean(value = TEMPLATE_AUDIT)
    public RabbitTemplate auditTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactoryAudit());
        rabbitTemplate.setExchange(TOPIC_EXCHANGE_AUDIT);

        return rabbitTemplate;
    }

}

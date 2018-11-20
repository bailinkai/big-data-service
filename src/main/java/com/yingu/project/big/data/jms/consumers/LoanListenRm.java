package com.yingu.project.big.data.jms.consumers;

import com.yingu.project.big.data.configuration.MessageListenerAuditCondition;
import com.yingu.project.big.data.jms.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
@Slf4j
@Component
@Conditional(MessageListenerAuditCondition.class)
public class LoanListenRm {

    private static final String UTF8_CHARSET = "UTF-8";

    @RabbitListener(queues = RabbitMqConfig.QUEUE_LOAN_RM, containerFactory = RabbitMqConfig.LISTENER_PUHUI)
    public void handleMessage(Message message) {
        try {

            String inboundMessage = new String(message.getBody(), UTF8_CHARSET);
            log.info("进件信息:\n {}", inboundMessage);

        }catch (Exception e) {
            log.error("进件信息", e);
        }

    }

}






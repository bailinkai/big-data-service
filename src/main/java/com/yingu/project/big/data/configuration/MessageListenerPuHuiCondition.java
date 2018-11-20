package com.yingu.project.big.data.configuration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
public class MessageListenerPuHuiCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return "true".equals(context.getEnvironment().getProperty("spring.rabbitmq.puhui.listener"));
    }
}

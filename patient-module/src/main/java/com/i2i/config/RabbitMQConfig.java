package com.i2i.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.queue}")
    private String queue;

    @Value("${app.rabbitmq.routing-key}")
    private String routingKey;

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue queue() {
        return new Queue(queue);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(directExchange()).with(routingKey);
    }
}

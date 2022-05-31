package com.example.bl_lab1.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpManagementOperations;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitManagementTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class RabbitConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.rabbitmq")
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory();
    }
    
    @Bean
    public AmqpAdmin AmqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }
    
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }
    
    @Bean
    public AmqpManagementOperations amqpManagementOperations() {
        AmqpManagementOperations amqpManagementOperations = new RabbitManagementTemplate(
              "http://192.168.19.200:15672", "admin", "admin@123");
        return amqpManagementOperations;
    }
    
    
    @Bean
    public Queue mqttQueue() {
        return new Queue("mqttQueue", true, false, false);
    }
}

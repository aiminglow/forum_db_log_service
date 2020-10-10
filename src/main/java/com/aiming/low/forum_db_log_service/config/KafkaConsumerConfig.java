package com.aiming.low.forum_db_log_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @ClassName KafkaConsumerConfig
 * @Description
 * @Author aiminglow
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    // 目前没有特殊的配置要求，只需要使用spring boot对kafka的autoconfig就行了（在yaml配置最基础的配置）
    // 虽然不需要注入@Bean，但是必须在有@Configuration注解的地方加上@EnableKafka注解，从而让@KafkaListener能够有效
}

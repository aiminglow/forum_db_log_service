package com.aiming.low.forum_db_log_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @ClassName KafkaTopicConfig
 * @Description
 * @Author aiminglow
 */
@Configuration
public class KafkaTopicConfig {
    public static final String DB_LOG_TOPIC = "dbLog";
    @Bean
    public NewTopic dbLog() {
        return TopicBuilder.name(DB_LOG_TOPIC).partitions(3).replicas(3).build();
    }
}

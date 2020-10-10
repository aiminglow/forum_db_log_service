package com.aiming.low.forum_db_log_service.mq;

import com.aiming.low.forum_db_log_service.dao.ImmutableDbLogMapper;
import com.aiming.low.forum_db_log_service.entity.ImmutableDbLog;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.aiming.low.forum_db_log_service.config.KafkaTopicConfig.DB_LOG_TOPIC;

/**
 * @ClassName KafkaDbLogConsumer
 * @Description
 * @Author aiminglow
 */
@Component
public class KafkaDbLogConsumer {
    private final ImmutableDbLogMapper dbLogMapper;

    public KafkaDbLogConsumer(ImmutableDbLogMapper dbLogMapper) {
        this.dbLogMapper = dbLogMapper;
    }

    // 这里不用制定groupId，spring会自动帮你指定yaml里面配置好的groupId，所以说spring kafka是必须要求groupId的？
    @KafkaListener(topics = DB_LOG_TOPIC, concurrency = "3")
    public void listen(ImmutableDbLog dbLog) {
        dbLogMapper.insert(dbLog);
    }
}

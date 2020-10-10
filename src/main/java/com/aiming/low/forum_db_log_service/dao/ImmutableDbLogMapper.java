package com.aiming.low.forum_db_log_service.dao;

import com.aiming.low.forum_db_log_service.entity.ImmutableDbLog;

public interface ImmutableDbLogMapper {
    int insert(ImmutableDbLog dbLog);
}

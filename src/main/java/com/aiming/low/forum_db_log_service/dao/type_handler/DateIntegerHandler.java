package com.aiming.low.forum_db_log_service.dao.type_handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @ClassName DateIntegerHandler
 * @Description
 * @Author aiminglow
 */

/**
 * 数据库中，与时间相关的字段采用了unsigned int，所以取值范围是0~2^32，
 * 而java的int类型取值范围是-2^31~2^31，所以在java代码中要使用long来获取数据库中转换过来的值
 *
 * 这种转换在myBatis的官方TypeHandler也有，如果jdbcType为integer的话，一般情况是转成java的integer类型，
 * 但如果数据库类型是unsigned int就转换成java的long类型
 */
@MappedTypes({Date.class})
@MappedJdbcTypes(JdbcType.INTEGER)
public class DateIntegerHandler implements TypeHandler<Date> {
    @Override
    public Date getResult(ResultSet rs, String columnName) throws SQLException {
        long seconds = rs.getLong(columnName);
        if (seconds == 0) {
            return null;
        }
        Date date = new Date(seconds * 1000);
        return date;
    }

    @Override
    public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
        long seconds = rs.getLong(columnIndex);
        if (seconds == 0) {
            return null;
        }
        Date date = new Date(seconds * 1000);
        return date;
    }

    @Override
    public Date getResult(CallableStatement cs, int columnIndex) throws  SQLException {
        long seconds = cs.getLong(columnIndex);
        if (seconds == 0) {
            return null;
        }
        Date date = new Date(seconds * 1000);
        return date;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        long seconds = parameter.getTime() / 1000;
        ps.setLong(i, seconds);
    }
}

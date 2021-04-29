package com.example.dao.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@MappedTypes(Date.class)
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class CustomDateTypeHandler extends BaseTypeHandler<Date> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date date, JdbcType jdbcType) throws SQLException {
        ps.setString(i, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnLabel) throws SQLException {
        return rs.getDate(columnLabel);
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getDate(columnIndex);
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int parameterIndex) throws SQLException {
        return cs.getDate(parameterIndex);
    }
}

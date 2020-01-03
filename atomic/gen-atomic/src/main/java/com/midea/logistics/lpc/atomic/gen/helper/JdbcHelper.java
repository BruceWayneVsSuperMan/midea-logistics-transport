package com.midea.logistics.lpc.atomic.gen.helper;

import com.midea.logistics.lpc.atomic.gen.util.ResultSetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class JdbcHelper {

    private static final Logger logger = LoggerFactory.getLogger(JdbcHelper.class);

    public static List<Map> jdbcExecutor(Connection conn, String sql) {
        Statement statement = null;

        try {
            statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sql);
            List<Map> maps = ResultSetMapper.toMapList(results);
            List var5 = maps;
            return var5;
        } catch (SQLException var15) {
            logger.error("SQLException", var15);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException var14) {
                    logger.error("SQLException", var14);
                }
            }

        }

        return null;
    }

}

package com.midea.logistics.lpc.atomic.gen.pojo;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mideaframework.core.utils.encript.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataSource {
    private static final Logger logger = LoggerFactory.getLogger(DataSource.class);
    private static Map<String, DruidPooledConnection> dataConns = null;
    private String url;
    private String driverClassName = "com.mysql.jdbc.Driver";
    private String username;
    private String password;

    public DataSource() {
    }

    public static synchronized DruidPooledConnection getConnect(DataSource dataSource) {
        if (dataConns == null) {
            dataConns = new HashMap();
        }

        String url = dataSource.getUrl();
        String hex = MD5Utils.encript(url);
        DruidPooledConnection conn = (DruidPooledConnection) dataConns.get(hex);

        try {
            if (conn == null || conn.isClosed()) {
                DruidDataSource druidDataSource = getDruidDataSource(dataSource);
                conn = druidDataSource.getConnection();
                dataConns.put(hex, conn);
            }
        } catch (SQLException var5) {
            logger.error("SQLException", var5);
        }

        return conn;
    }

    private static DruidDataSource getDruidDataSource(DataSource dataSource) {
        DruidDataSource db = new DruidDataSource();
        db.setUrl(dataSource.getUrl());
        db.setDriverClassName(dataSource.getDriverClassName());
        db.setUsername(dataSource.getUsername());
        db.setPassword(dataSource.getPassword());
        db.setInitialSize(1);
        db.setMinIdle(1);
        db.setMaxActive(20);
        db.setRemoveAbandoned(true);
        db.setRemoveAbandonedTimeout(30);
        db.setMaxWait(20000L);
        db.setTimeBetweenEvictionRunsMillis(20000L);
        db.setValidationQuery("SELECT 'x'");
        db.setTestWhileIdle(true);
        db.setTestOnBorrow(true);
        return db;
    }

    public static Map<String, DruidPooledConnection> getDataConns() {
        return dataConns;
    }

    public static void setDataConns(Map<String, DruidPooledConnection> dataConns) {
        DataSource.dataConns = dataConns;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return this.driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

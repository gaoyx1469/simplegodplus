package top.util.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import top.util.properties.PropertiesUtil;

public class TransactionUtil {

    private static final ThreadLocal<Connection> tl = new ThreadLocal<>();
    private static DataSource ds = null;

    static {
        try {
            // 数据源工厂根据properties文件创建数据源
            ds = BasicDataSourceFactory
                    .createDataSource(PropertiesUtil.getPropertiesByClassloader("dbcpconfig.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取数据源
    public static DataSource getDataSource() {
        return ds;
    }

    // 获取连接，如是首次获取，则将连接放到ThreadLocal中
    public static Connection getConnection() {
        try {
            Connection conn = tl.get();
            if (conn == null) {
                conn = ds.getConnection();
                tl.set(conn);
            }
            //System.out.println("通过TransactionUtil获取连接|Connection--" + conn);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 开启事务，如没有连接，获取连接并放到ThreadLocal中
    public static void startTransaction() {
        try {
            Connection conn = tl.get();
            if (conn == null) {
                conn = getConnection();
            }
            //System.out.println("通过TransactionUtil开启事务|Connection--" + conn);
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 回滚事务，如没有连接，获取连接并放到ThreadLocal中
    public static void rollback() {
        try {
            Connection conn = tl.get();
            if (conn == null) {
                conn = getConnection();
            }
            //System.out.println("通过TransactionUtil回滚事务|Connection--" + conn);
            conn.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 提交事务，如没有连接，获取连接并放到ThreadLocal中
    public static void commit() {
        try {
            Connection conn = tl.get();
            if (conn == null) {
                conn = getConnection();
            }
            //System.out.println("通过TransactionUtil提交事务|Connection--" + conn);
            conn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 释放连接，如有连接，释放连接并清空ThreadLocal中本线程的Connection
    public static void release() {
        try {
            Connection conn = tl.get();
            if (conn != null) {
                //System.out.println("通过TransactionUtil释放连接|Connection--" + conn);
                conn.close();
                tl.remove();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

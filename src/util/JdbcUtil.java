package util;

import java.sql.*;


public class JdbcUtil {
    static Connection connection;

    //1.getConnection 获取数据库连接的方法，返回一个Connection对象
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        final String URL = "jdbc:mysql://localhost:3306/temptest?characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
        final String username = "root";
        final String password = "asdfgh123456";
        Connection conn = DriverManager.getConnection(URL,username,password);
        JdbcUtil.connection = conn;
        if (conn == null) {
            System.out.println("创建连接失败");
            close();
            return null;
        } else {
            System.out.println("创建连接成功");
            return conn;
        }
    }

    //2.getPrepareStatement  获取statement接口方法
    public static PreparedStatement getPrepareStatement(String sql) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        PreparedStatement ppsm = (PreparedStatement) conn.prepareStatement(sql);
        return ppsm;
    }

    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {                        //避免出现空指针异常
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close() {
        if (JdbcUtil.connection != null) {
            try {
                JdbcUtil.connection.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }



}

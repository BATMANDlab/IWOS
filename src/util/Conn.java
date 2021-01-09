package util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Conn {
	private static String url="jdbc:mysql://127.0.0.1/iwos?useUnicode=true&characterEncoding=utf-8&useSSL=true";
    private static String Username="root";
    private static String Password="123456";
    private static String Drivername="com.mysql.jdbc.Driver";
    public static Connection connection=null;

    public static Connection getConnection() {

    try {
        Class.forName(Drivername);
        connection=(Connection) DriverManager.getConnection(url, Username, Password);
    } catch (ClassNotFoundException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
    }
    return connection;
}
/**
 * 关闭数据库连接
 * @param connection
 * @param statement
 * @param resultSet
 */
public static void release(Connection connection, Statement statement, ResultSet resultSet) {


    try {
        if(resultSet!=null) {
            resultSet.close();
        }
        if(statement!=null) {
            statement.close();
        }
        if(connection!=null) {
            connection.close();
        }
    } catch (SQLException e) {
        // TODO 自动生成的 catch 块
        e.printStackTrace();
    }
}
}

package com.icss.utill;

import java.sql.*;

public class DbUtil {
    private  static Connection connection;
    private  static PreparedStatement preparedStatement;
    private  static ResultSet resultSet;
    public static Connection getConnection(){
        /*
         * 获得连接
         */
        try {
            //加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //获得连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","scott","tiger");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static int executeUpdate(String sql,Object...params){
        connection = getConnection();
        int rst  = 0;
        try{
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i+1,params[i]);
            }
            //返回更新记录的数量
            rst = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection();
        }

        return rst;
    }

    /**
     * 查询1
     * @param sql
     * @return
     */
    public static int executeQuery1(String sql){
        connection = getConnection();
        int rst = 0;
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getObject(1)+"\t"+resultSet.getObject("dname")+"\t"+resultSet.getObject(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rst;
    }

    /**
     * 查询2
     */
    public static ResultSet executeQuery(String sql,Object...params){
        connection=getConnection();
        try {
            preparedStatement=connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    /*
     *关闭连接
     */
    public  static  void closeConnection(){
        try {
            if(null != resultSet) {
                resultSet.close();
            }
            if(null != preparedStatement) {
                preparedStatement.close();
            }
            if (null != connection) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

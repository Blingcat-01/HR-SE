package com.icss.dao;
import com.icss.entity.Admin;
import com.icss.utill.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AdminDao {
    //添加功能
    public int insertAdmins(Admin admin) {
        String sql = "insert into admin values(?,?,?,?)";
        int rst = DbUtil.executeUpdate(sql, admin.getId(), admin.getUser_Name(), admin.getUser_Password(), admin.getRole());
        return rst;
    }

    //确认账号密码功能
    public Admin selecyAdminByUserNameAndPwd(String username, String password) {
        Admin admin = null;
        String sql = "select * from admin where username=? and password = ?";
        ResultSet resultSet = DbUtil.executeQuery(sql, username, password);
        try {
            if (resultSet.next()) {
                admin = new Admin(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection();
        }
        return admin;
    }
}
    //浏览功能
   /* public List<Admin> selec?

        String sqlname = "select count(1) from admin where username = ?";
        int rows=0;
        int rows1= 1;
        ResultSet resultSet = DbUtil.executeQuery(sqlname,admin.getUser_Name());
        try {
            if(resultSet.next()){
                rows = resultSet.getInt(1);
                if (rows>0){
                   // System.out.println("账号正确");
                    String sqlpassword = "select count(1) from admin where password = ?";
                    ResultSet resultSet1 = DbUtil.executeQuery(sqlpassword,admin.getUser_Password());
                    if (resultSet1.next()){
                       // System.out.println("密码正确");
                        rows1=resultSet1.getInt(1);
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rows>0){
            //System.out.println("账号正确");
            if(rows1>0){
             //   System.out.println("密码正确");
                istrue=true;
            }else {
            //    System.out.println("密码错误");
                istrue=false;
            }
        }else {
           // System.out.println("账号错误");
            istrue=false;
        }
        return istrue;
    }

*/

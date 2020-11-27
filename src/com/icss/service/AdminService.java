package com.icss.service;

import com.icss.dao.AdminDao;
import com.icss.entity.Admin;
import com.icss.utill.DbUtil;

import java.sql.Date;
import java.sql.SQLException;

public class AdminService {

    AdminDao adminDao = new AdminDao();
    //添加功能
    public int insertAdmins(Admin admin){
        return adminDao.insertAdmins(admin);
    }
    //登录功能
    public Admin selecyAdminByUserNameAndPwd(String username, String password) {
        return adminDao.selecyAdminByUserNameAndPwd(username, password);
    }
}

/*    public void selecyAdminByUserNameAndPwd(String username, String password){
        if (adminDao.selecyAdminByUserNameAndPwd(username,password)==null{
            System.out.println("账户密码错误");
        }else{

        }
           */




   /* AdminDao adminDao = new AdminDao();
    public  boolean inspectAdmins_Username (Admin admin){
        if (adminDao.inspectAdmin_Username(admin)){
        }else {
            try {
                throw  new Exception("账号密码错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return adminDao.inspectAdmin_Username(admin);
    }*/


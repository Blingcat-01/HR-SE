package com.icss.dao;

import com.icss.entity.Dept;
import com.icss.utill.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {
    public List<Dept> SelectAllDepts() {
        List<Dept> resultList = new ArrayList<>();
        String sql = "select * from dept ";
        ResultSet resultSet = DbUtil.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Dept dept = new Dept(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                resultList.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection();
        }
        return resultList;
    }

    public int insertDept(Dept dept) {//编号和名称不能重复
        String sql = "insert into dept values(?,?,?)";
        int rst = DbUtil.executeUpdate(sql, dept.getDeptNo(), dept.getDeptName(), dept.getDeptLoc());
        return rst;
    }

    public int deletDept(int deptNo) {
        String sql = "delete dept where deptno=?";
        int rst = DbUtil.executeUpdate(sql, deptNo);
        return rst;
    }

    public int selectDeptNumByID(int deptNo) {
        String sql = "select count(1) from dept where deptno = ?";
        int rows = 0;
        ResultSet resultSet = DbUtil.executeQuery(sql, deptNo);
        try {
            if (resultSet.next()) {
                rows = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;

    }

    public int changeDept(Dept dept) {
        String sql = "update dept set dname=? ,loc=? where deptno=?";
        int rst = DbUtil.executeUpdate(sql, dept.getDeptName(), dept.getDeptLoc(), dept.getDeptNo());
        return rst;
    }
}




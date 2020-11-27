package com.icss.dao;

import com.icss.entity.Employee;
import com.icss.utill.DbUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public int insertEmployees(Employee employee){
        String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
        int rst = DbUtil.executeUpdate(sql,employee.getEmpNo(),employee.getEmpName(),employee.getEmpJob(),employee.getMgr(),Date.valueOf( employee.getEmphiredate()),employee.getSal(),employee.getComm(),employee.getDeptNo());
        return rst;
    }

    public int deleteeEmployees(int empNo) {
        String sql = "delete emp where empno=?";
        int rst = DbUtil.executeUpdate(sql,empNo);
        return rst;
    }

    public int selectEmployeesNumByID(int empNo){
        String sql = "select count(1) from emp where empno=?";
        int rows = 0;
        ResultSet resultSet = DbUtil.executeQuery(sql,empNo);
        try{
            if(resultSet.next()){
                rows = resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rows;
    }


    public int updateEmployees(Employee employee) {
        String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=?  where empno=?";
        int rst = DbUtil.executeUpdate(sql,employee.getEmpName(),employee.getEmpJob(),employee.getMgr(),employee.getEmphiredate(),employee.getSal(),employee.getComm(),employee.getDeptNo(),employee.getEmpNo());
        return rst;
    }

    public List<Employee> selectAllEmployees() {
        List<Employee> resultList = new ArrayList<>();
        String sql = "select * from emp ";
        ResultSet resultSet = DbUtil.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getDouble(6),resultSet.getDouble(7),resultSet.getInt(8));
                resultList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConnection();
        }
        return  resultList;
    }
}



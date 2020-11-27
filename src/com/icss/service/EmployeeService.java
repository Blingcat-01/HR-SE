package com.icss.service;

import com.icss.dao.EmployeeDao;
import com.icss.entity.Employee;

import java.util.List;

public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDao();
    public List<Employee> SelectallEmployee(){return employeeDao.selectAllEmployees();}
    public int InserEmployee(Employee employee){return employeeDao.insertEmployees(employee);}

    public int Deleteemployee(int empno) throws Exception {
        int rows = employeeDao.selectEmployeesNumByID(empno);
        if (rows >0) {
            return employeeDao.deleteeEmployees(empno);
        }else {
            throw new Exception("员工编号不存在");
        }
    }
    public int UpdateEmployees(Employee employee) {
        return employeeDao.updateEmployees(employee);
    }
}

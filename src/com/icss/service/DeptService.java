package com.icss.service;

import com.icss.dao.DeptDao;
import com.icss.entity.Dept;

import java.util.List;

public class DeptService {
    DeptDao deptDao = new DeptDao();
    public List<Dept> SelectAllDepts(){
        return deptDao.SelectAllDepts();
    }
    public int insertDept(Dept dept){ return deptDao.insertDept(dept);}
    public int deleteDept(int deptNo) throws Exception {
        int rows = deptDao.selectDeptNumByID(deptNo);
        if (rows>0){
            return  deptDao.deletDept(deptNo);
        }else {
            throw new Exception("部门编号不存在");
        }
    }
    public int changeDept(Dept dept){return deptDao.changeDept(dept);}
}

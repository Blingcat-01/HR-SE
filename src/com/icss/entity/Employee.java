package com.icss.entity;

public class Employee {
    private int empNo;
    private  String empName;
    private  String empJob;
    private int mgr;
    private String emphiredate;
    private double sal;
    private double comm;
    public int deptNo;

    public Employee(int empNo, String empName, String empJob, int mgr, String emphiredate, double sal, double comm, int deptNo) {
        this.empNo = empNo;
        this.empName = empName;
        this.empJob = empJob;
        this.mgr = mgr;
        this.emphiredate = emphiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptNo = deptNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public String getEmphiredate() {
        return emphiredate;
    }

    public void setEmphiredate(String emphiredate) {
        this.emphiredate = emphiredate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
}

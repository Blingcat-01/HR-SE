package com.icss.view;

import com.icss.entity.Admin;
import com.icss.entity.Dept;
import com.icss.entity.Employee;
import com.icss.service.AdminService;
import com.icss.service.DeptService;
import com.icss.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class MainView {
    //ctrl+d快捷粘贴到下一行
    Scanner sc = new Scanner(System.in);
        DeptService deptService = new DeptService();
        EmployeeService employeeService = new EmployeeService();
        AdminService adminService = new AdminService();
    public static void main(String[] args) {
        MainView mainView = new MainView();
        mainView.login();
    }

    /**
     *输入登录界面
     */
    private void login(){
        int isContinue = 0;
        System.out.println("=====系统登录界面=====");
        while (isContinue<3){
            System.out.println("请输入账号");
            String a=sc.next();
            System.out.println("请输入密码");
            String b=sc.next();
            Admin admin =adminService.selecyAdminByUserNameAndPwd(a,b);
           if (null == admin){
               System.out.println("账号密码错误");
           }else if(admin.getRole()==1){
               top_Admin_View();//管理界面
           }else {
               top_User_View();//普通用户界面
           }
           isContinue++;
            System.out.println("账号密码已经输入失败"+isContinue+"次|一共三次机会");
          /*我写的
            AdminService adminService =new AdminService();
             if (adminService.inspectAdmins_Username(admin)){
                 System.out.println("登陆成功");
                 topView();
             }else{
                 isContinue++;
             }*/
        }
        System.out.println("三次密码错误已经退出");
    }

    /**
     * 主画面用户模式
     */
    private void top_User_View() {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("=======用户模式========");
            System.out.println("部门管理-----------1");
            System.out.println("员工管理-----------2");
            System.out.println("程序退出-----------3");
            System.out.println("重新选择模式--------4");
            System.out.println("=======================");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    dept_User_View();
                    break;
                case 2:
                    employee_User_View();
                    break;
                case 3:
                    System.exit(0);
                    break;
                case 4:
                    login();
                    break;

            }
        }
    }

    /**
     * 主界面管理员模式
     */

    private void top_Admin_View() {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("=======管理员模式========");
            System.out.println("部门管理-----------1");
            System.out.println("员工管理-----------2");
            System.out.println("管理员管理---------3");
            System.out.println("程序退出-----------4");
            System.out.println("重新选择模式-------5");
            System.out.println("========================");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    deptView();
                    break;
                case 2:
                    employeeView();
                    break;
                case 3:
                    adminView();
                case 4:
                    System.exit(0);
                    break;
                case 5:
                    login();
                    break;
            }
        }
    }

    /**
     * 管理管理员-管理员模式
     */
    private void adminView() {
        System.out.println("====================");
        System.out.println("1.添加管理员========");
        System.out.println("2.修改管理员========");
        System.out.println("3.删除管理员========");
        System.out.println("4.查询所有管理员信息=");
        System.out.println("5.返回首页==========");
        System.out.println("输入要执行的操作:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
               addAdminView();
                break;
            case 2:
               // modfyadminView();
                break;
            case 3:
            //    delEadminView();
                break;
            case 4:
               listadminView();
                break;
            case 5:
                top_Admin_View();
                break;

        }
    }

    /**
     * 展示管理员-管理员模式
     */
    private void listadminView() {
    }

    /**
     * 添加管理员-管理员模式
     */
    private void addAdminView() {
        System.out.println("输入添加的管理员编号");
        int a=sc.nextInt();
        System.out.println("输入添加的管理员账号");
        String b = sc.next();
        System.out.println("输入添加的员工密码");
        String c = sc.next();
        System.out.println("输入添加的员工权限号");
        int d = sc.nextInt();
        Admin admin = new Admin(a,b,c,d);
        int rst =adminService.insertAdmins(admin);
        System.out.println(rst>0?"添加成功":"添加失败");
        adminView();
    }

    /**
     * 员工管理界面-用户模式
     */
    private void employee_User_View(){
        System.out.println("====================");
        System.out.println("1.查询所有员工信息======");
        System.out.println("2.返回首页============");
        System.out.println("输入要执行的操作:");
        System.out.println("====================");
        int choice  = sc.nextInt();
        switch (choice){
            case 1:
                listEmpolyeeView();
                employee_User_View();
                break;
            case 5:
                top_User_View();
                break;

        }
    }

    /**
     * 员工管理界面-管理员模式
     */
    private void employeeView(){
        System.out.println("====================");
        System.out.println("1.添加员工===========");
        System.out.println("2.修改员工===========");
        System.out.println("3.删除员工===========");
        System.out.println("4.查询所有员工信息======");
        System.out.println("5.返回首页============");
        System.out.println("输入要执行的操作:");
        System.out.println("====================");
        int choice  = sc.nextInt();
        switch (choice){
            case 1:
                addEmpolyeeView();
                break;
            case 2:
                modfyEmpolyeeView();
                break;
            case 3:
                delEmpolyeeView();
                break;
            case 4:
                listEmpolyeeView();
                employeeView();
                break;
            case 5:
                top_Admin_View();
                break;

        }
    }

    /**
     * 员工展示功能界面-通用模式
     */
    private void listEmpolyeeView() {
        List<Employee> employees = employeeService.SelectallEmployee();
        System.out.println("员工编号\t员工姓名\t员工职位\t领导编号\t入职时间\t职员薪资\t职员追加薪资\t部门编号");
        for (Employee employee: employees) {
            System.out.println(employee.getEmpNo()+"\t\t"+employee.getEmpName()+"\t\t"+employee.getEmpJob()+"\t\t"+employee.getMgr()+"\t\t"+employee.getEmphiredate()+"\t\t"+employee.getSal()+"\t\t"+employee.getComm()+"\t\t"+employee.getEmpNo());
        }
        //employeeView();
    }

    /**
     * 删除员工功能界面-管理员模式
     */
    private void delEmpolyeeView(){
        System.out.println("输入要删除的编号");
        int a=sc.nextInt();
        int rst=0;
        try {
            rst =employeeService.Deleteemployee(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(rst>0?"删除成功":"删除失败");
        employeeView();
    }

    /**
     * 修改员工界面-管理员模式
     */
    private void modfyEmpolyeeView() {
        System.out.println("输入修改员工编号");
        int a=sc.nextInt();
        System.out.println("输入修改员工名称");
        String b = sc.next();
        System.out.println("输入修改员工职位");
        String c = sc.next();
        System.out.println("输入修改员工领导编号");
        int d=sc.nextInt();
        System.out.println("输入修改员工入职时间");
        String e = sc.next();
        System.out.println("输入修改员工薪资");
        int f=sc.nextInt();
        System.out.println("输入修改员工追加薪资");
        int g=sc.nextInt();
        System.out.println("输入修改员工所属部门编号");
        int h=sc.nextInt();
        Employee employee = new Employee(a,b,c,d,e,f,g,h);
        int rst =employeeService.UpdateEmployees(employee);
        System.out.println(rst>0?"修改成功":"修改失败");
        deptView();

    }

    /**
     * 添加员工界面-管理员模式
     */
    private void addEmpolyeeView() {
        System.out.println("输入添加的员工编号");
        int a=sc.nextInt();
        System.out.println("输入添加的员工姓名");
        String b = sc.next();
        System.out.println("输入添加的员工职位");
        String c = sc.next();
        System.out.println("输入添加的员工得领导编号");
        int d = sc.nextInt();
        System.out.println("输入添加的员工入职日期");
        String e = sc.next();
        System.out.println("输入添加的员工薪资");
        Double f = sc.nextDouble();
        System.out.println("请输入追加薪资");
        Double g = sc.nextDouble();
        System.out.println("请输入部门编号");
        int h  = sc.nextInt();
        Employee employee = new Employee(a,b,c,d,e,f,g,h);
        int rst =employeeService.InserEmployee(employee);
        System.out.println(rst>0?"添加成功":"添加失败");
       employeeView();

    }

    /**
     * 部门管理界面-用户模式
     */
    private void dept_User_View() {
        System.out.println("====================");
        System.out.println("1.查询所有和部门======");
        System.out.println("2.返回首页============");
        System.out.println("输入要执行的操作:");
        System.out.println("====================");
        int choice  = sc.nextInt();
        switch (choice){
            case 1:
                listDeptView();
                dept_User_View();
                break;
            case 2:
                top_User_View();
                break;

        }
    }

    /**
     * 部门管理界面-管理员模式
     */
    private void deptView(){
        System.out.println("====================");
        System.out.println("1.添加部门===========");
        System.out.println("2.修改部门===========");
        System.out.println("3.删除部门===========");
        System.out.println("4.查询所有和部门======");
        System.out.println("5.返回首页============");
        System.out.println("输入要执行的操作:");
        System.out.println("====================");
        int choice  = sc.nextInt();
        switch (choice){
            case 1:
                addDeptView();
                break;
            case 2:
               modfyDeptView();
                break;
            case 3:
               delDeptView();
                break;
            case 4:
                listDeptView();
                deptView();
                break;
            case 5:
                top_Admin_View();
                break;

        }
    }

    /**
     * 删除部门界面-管理员模式
     */
    private void delDeptView() {

        System.out.println("输入要删除的编号");
        int a=sc.nextInt();
        int rst=0;
        try {
            rst =deptService.deleteDept(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(rst>0?"删除成功":"删除失败");
        deptView();
    }

    /**
     * 修改部门界面-管理员模式
     */
    private void modfyDeptView() {

        System.out.println("输入修改部门编号");
        int a=sc.nextInt();
        System.out.println("输入修改部门名称");
        String b = sc.next();
        System.out.println("输入修改部门地址");
        String c = sc.next();
        Dept dept = new Dept(a,b,c);
        int rst =deptService.changeDept(dept);
        System.out.println(rst>0?"修改成功":"修改失败");
        deptView();
    }

    /**
     * 添加部门界面-管理员模式
     */
    private void addDeptView() {

        System.out.println("输入添加的编号");
        int a=sc.nextInt();
        System.out.println("输入添加的名称");
        String b = sc.next();
        System.out.println("输入添加的地址");
        String c = sc.next();
        Dept dept = new Dept(a,b,c);
        int rst =deptService.insertDept(dept);
        System.out.println(rst>0?"添加成功":"添加失败");
        deptView();
    }

    /**
     * 展示部门界面-通用模式
     */
    private void listDeptView(){
        List<Dept> detps = deptService.SelectAllDepts();
        System.out.println("部门编号\t部门名称\t部门地址");
        for (Dept dept: detps) {
            System.out.println(dept.getDeptNo()+"\t\t"+dept.getDeptName()+"\t\t"+dept.getDeptLoc());
        }
        //deptView();
    }

}
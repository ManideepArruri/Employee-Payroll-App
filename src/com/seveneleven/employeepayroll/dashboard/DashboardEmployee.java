package com.seveneleven.employeepayroll.dashboard;

public class DashboardEmployee {

    private String empId;
    private String name;

    public DashboardEmployee(String empId,String name){
        this.empId = empId;
        this.name = name;
    }

    public String getEmpId(){
        return empId;
    }

    public String getName(){
        return name;
    }
}
package com.seveneleven.employeepayroll.dashboard;

public class DashboardPayslip {

    private String month;
    private double netPay;

    public DashboardPayslip(String month,double netPay){
        this.month = month;
        this.netPay = netPay;
    }

    public String getMonth(){
        return month;
    }

    public double getNetPay(){
        return netPay;
    }

    @Override
    public String toString(){
        return month + " : " + netPay;
    }
}

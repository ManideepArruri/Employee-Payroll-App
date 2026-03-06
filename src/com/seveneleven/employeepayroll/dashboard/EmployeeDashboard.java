package com.seveneleven.employeepayroll.dashboard;

import java.util.*;

public class EmployeeDashboard implements Dashboard {

    @Override
    public void display(ArrayList<DashboardPayslip> payslips, DashboardEmployee employee) {

        System.out.println("\n=== EMPLOYEE DASHBOARD ===");
        System.out.println("Welcome, " + employee.getName());

        System.out.println("Dashboard Type : " + this.getClass().getName());

        Collections.sort(payslips,new Comparator<DashboardPayslip>() {

            public int compare(DashboardPayslip p1,DashboardPayslip p2){

                return (int)(p2.getNetPay() - p1.getNetPay());

            }

        });

        System.out.println("\nRecent Payslips (Top 3):");

        int count = 0;

        Iterator<DashboardPayslip> it = payslips.iterator();

        while(it.hasNext() && count < 3){

            DashboardPayslip p = it.next();

            System.out.println(p);

            count++;

        }

        double total = 0;

        Iterator<DashboardPayslip> it2 = payslips.iterator();

        while(it2.hasNext()){

            DashboardPayslip p = it2.next();

            total += p.getNetPay();

        }

        System.out.println("\nYear-To-Date Earnings: " + total);
    }

}
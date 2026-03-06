package com.seveneleven.employeepayroll.dashboard;

import java.util.*;

public class ManagerDashboard implements Dashboard {

    @Override
    public void display(ArrayList<DashboardPayslip> payslips, DashboardEmployee employee) {

        System.out.println("\n=== MANAGER DASHBOARD ===");

        System.out.println("Manager : " + employee.getName());

        System.out.println("Dashboard Type : " + this.getClass().getName());

        double total = 0;

        Iterator<DashboardPayslip> it = payslips.iterator();

        while(it.hasNext()){

            DashboardPayslip p = it.next();

            total += p.getNetPay();

        }

        System.out.println("\nTeam Total YTD Earnings : " + total);

    }

}
package com.seveneleven.employeepayroll.dashboard;

import java.util.ArrayList;

public interface Dashboard {

    void display(ArrayList<DashboardPayslip> payslips, DashboardEmployee employee);

}

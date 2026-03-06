package com.seveneleven.employeepayroll.service;

import com.seveneleven.employeepayroll.model.Employee;
import com.seveneleven.employeepayroll.model.RegularEmployee;
import com.seveneleven.employeepayroll.persistence.DataStore;

public class EmployeeService {
	public void registerEmployee(Employee employee){

        String username = employee.getAccount().getUsername();
        String password = employee.getAccount().getPassword();

        RegularEmployee user = new RegularEmployee(username,password);

        DataStore.users.put(username,user);

        System.out.println("Employee registered successfully!");

    }
}

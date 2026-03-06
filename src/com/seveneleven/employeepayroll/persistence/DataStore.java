package com.seveneleven.employeepayroll.persistence;

import java.util.HashMap;
import java.util.Map;

import com.seveneleven.employeepayroll.model.Employee;
import com.seveneleven.employeepayroll.model.User;

public class DataStore {
	public static Map<String, User> users = new HashMap<>();
	public static Map<String,Employee> employees = new HashMap<>();
}

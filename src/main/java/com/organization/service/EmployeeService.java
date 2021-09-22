package com.organization.service;

import java.util.List;

import com.organization.enitity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	public Employee saveEmployees(Employee employee);
	Employee getEmployeeByIdWithOrgName(Integer empId, String orgName);

}

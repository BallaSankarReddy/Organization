package com.organization.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.enitity.Employee;

public interface EmployeeRepository {
	public List<Employee> getEmployees();
	public Integer saveEmployees(Employee employee);
	public Employee getEmployeeByIdWithOrgName(Integer empId, String orgName);

}

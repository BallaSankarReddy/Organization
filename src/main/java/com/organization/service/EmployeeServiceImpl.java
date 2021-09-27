package com.organization.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.enitity.Employee;
import com.organization.enitity.Organization;
import com.organization.pdf.PreparePDF;
import com.organization.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private OrganizationService organizationService;
	

	@Override
	public List<Employee> getEmployees() {

		List<Employee> employees = employeeRepository.getEmployees();
		return employees;
	}

	@Override
	public Employee saveEmployees(Employee employee) {

		Organization organization = organizationService.getOriginations().stream()
				.filter(orgName -> orgName.getOrigName().equalsIgnoreCase(employee.getCompanyName())).findFirst().get();

		employee.setOrgId(organization.getId());
		employee.setCreatedTimeStamp(new Date());
		employee.setModifiedTimeStamp(new Date());

		Integer empId = employeeRepository.saveEmployees(employee);
		employee.setId(empId);
		return employee;
	}

	@Override
	public Employee getEmployeeByIdWithOrgName(Integer empId, String orgName) {
		return employeeRepository.getEmployeeByIdWithOrgName(empId, orgName);
	}

}

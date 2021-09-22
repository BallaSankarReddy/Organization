package com.organization.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.organization.enitity.Employee;
import com.organization.pdf.PreparePDF;
import com.organization.service.EmployeeService;

@RequestMapping("/api/employee")
@RestController
@ResponseBody
public class EmployeeControllerImpl implements EmployeeController {
	private Logger logger = LoggerFactory.getLogger(EmployeeControllerImpl.class);

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private PreparePDF preparePDF;

	@Override
	public List<Employee> getEmployee() {
		logger.info("Fetching Employee details");
		return employeeService.getEmployees();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeService.saveEmployees(employee);
	}

	@Override
	public Employee getEmployeeByIdWithOrgName(Integer empId, String orgName) {
		// TODO Auto-generated method stub
		return employeeService.getEmployeeByIdWithOrgName(empId, orgName);
	}

	// @GetMapping("/users/export/pdf")
	@Override
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {

		
		  response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        PreparePDF prepare = new PreparePDF(getEmployee());
	        response.setHeader(headerKey, headerValue);
		preparePDF.export(response);
	}
}

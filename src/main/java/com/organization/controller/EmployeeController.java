package com.organization.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.organization.enitity.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "EmployeeController", description = "REST APIs related to Employee Entity!!!!")
@RequestMapping("/api/employee")
@RestController
public interface EmployeeController {
	
	@ApiOperation(value = "Get list of employee in the System ", tags = "getEmployee")

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Success|OK"),

			@ApiResponse(code = 401, message = "not authorized!"),

			@ApiResponse(code = 403, message = "forbidden!!!"),

			@ApiResponse(code = 404, message = "not found!!!") })

	@GetMapping(value = "/getEmployee")
	public List<Employee> getEmployee();
	
	
	@ApiOperation(value = "Create Employee in the System ", tags = "Create Employee")

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 201, message = "Success|Created"),

			@ApiResponse(code = 401, message = "not authorized!"),

			@ApiResponse(code = 403, message = "forbidden!!!"),

			@ApiResponse(code = 404, message = "not found!!!") })

	@PostMapping(value = "/save/employee")
	public Employee saveEmployee(@RequestBody Employee employee);


	
	@ApiOperation(value = "Get  employee details by empId with OrgId in the System ", tags = "getEmployee")

	@ApiResponses(value = {

			@ApiResponse(code = 200, message = "Success|OK"),

			@ApiResponse(code = 401, message = "not authorized!"),

			@ApiResponse(code = 403, message = "forbidden!!!"),

			@ApiResponse(code = 404, message = "not found!!!") })

	@GetMapping(value = "/getEmployee/{empId}/{orgName}")
	public Employee getEmployeeByIdWithOrgName(@PathVariable Integer empId, @PathVariable String orgName);
	
	@GetMapping("/users/export/pdf")
public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException;
	
}

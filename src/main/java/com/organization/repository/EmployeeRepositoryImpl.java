package com.organization.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.organization.common.BaseRepository;
import com.organization.enitity.Employee;

@Repository
public class EmployeeRepositoryImpl extends BaseRepository< Employee>implements EmployeeRepository {

	
	private final static String EMP_BY_EMPID_ORGID= "select *from ORIGINATION_DETAILS org inner join EMPLOYEE_DETAILS emp on org.id =emp.orgid where org.origname= :orgName and emp.id= :id";
	@Override
	public List<Employee> getEmployees() {
		
		return this.findAll(Employee.class);
	}

	@Override
	public Integer saveEmployees(Employee employee) {

		int empId = this.create(employee);
		
		return empId;
	}

	@Override
	public Employee getEmployeeByIdWithOrgName(Integer empId, String orgName) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		
		parameterSource.addValue("id", empId);
		parameterSource.addValue("orgName", orgName);
		return getNamedParameterJdbcTemplate().queryForObject(EMP_BY_EMPID_ORGID,parameterSource,BeanPropertyRowMapper.newInstance(Employee.class));
	}

}

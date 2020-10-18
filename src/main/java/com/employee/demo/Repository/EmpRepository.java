package com.employee.demo.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.employee.demo.entity.Employee;
import com.employee.demo.exception.ResourceNotFoundException;

//@Transactional
@Repository
public class EmpRepository implements EmpRepositoryInterface {
	
	private static final Logger LOGGER = Logger.getLogger(EmpRepository.class.getName());

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		
		String sql = "SELECT * FROM employees";
		RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<>(Employee.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public Employee getEmployeeById(long empId) {
		
		try {
		final String EMP_BY_ID="select * from employees where empId=?;"; 
	    List<Employee> query = jdbcTemplate.query(EMP_BY_ID, new BeanPropertyRowMapper<Employee>(Employee.class), empId);  
	    return DataAccessUtils.uniqueResult(query);
		}catch (EmptyResultDataAccessException e) {
			return null;
	}
	}
	
	//INSERT EMPLOYEE AND SKILL TOGETHER

	@Override
	public Employee addEmployee(Employee emp) {
		
		final String EMP_INSERT= "insert into employees (empId, firstName, lastName, hireDate, city, email, phoneNo) values (?, ?, ?, ?, ?, ?, ?) ";
		final String SKILL_INSERT="insert into skills (skillId, skillName, details,empId) values(?, ?, ?, ?)";
		
		jdbcTemplate.update(EMP_INSERT, emp.getEmpId(), emp.getFirstName(), emp.getLastName(), emp.getHireDate(), emp.getCity(), emp.getEmail(), emp.getPhoneNo());
		LOGGER.info("Inserted into Employee Table Successfully");
		
		jdbcTemplate.update(SKILL_INSERT, emp.getSkills().getSkillId(), emp.getSkills().getSkillName(), emp.getSkills().getDetails(), emp.getSkills().getEmpId());
		LOGGER.info("Inserted into Skill Table Successfully");
		
		return emp;
		
	}

	@Override
	public Employee updateEmployeeDetails(Employee employee) {
		
		final String UPDATE_EMPLOYEE="update employees set firstName=?, lastName=?, hireDate=?, email=?, city=?, phoneNo=? where empId=?;";
		jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getFirstName(), employee.getLastName(), employee.getHireDate(), employee.getEmail(), employee.getCity(), employee.getPhoneNo(), employee.getEmpId());
		return employee;
		
		
	}
	
	@Override
	public void deleteEmployeeDetails(long empId) {
		 
		final String DELETE_BY_ID = "delete from employees where empId=?";
		final String DELETESKILL_BY_ID = " delete from skills where empId=?";
		
		
		int skillSize= jdbcTemplate.update(DELETESKILL_BY_ID, empId);
		int size= jdbcTemplate.update(DELETE_BY_ID, empId);
		if(skillSize==0 || size==0) {
			throw new ResourceNotFoundException("no employee with "+empId+" to delete");
		}
		
	}
	
/* batch Insert - inserting multiple records at a time */

	@Override
	public int[] batchInsert(List<Employee> employees) {
		
		final String INSERT_EMP_QUERY = "insert into employees (empId,firstName, lastName, hireDate, city, email, phoneNo) values ( ?, ?, ?, ?, ?, ?, ?) ";
		
		return this.jdbcTemplate.batchUpdate(INSERT_EMP_QUERY,
	      new BatchPreparedStatementSetter() {
	      
	      @Override
	      public void setValues(PreparedStatement ps, int i) throws SQLException {
	        // emp id is auto generated so not provided
	    	ps.setLong(1, employees.get(i).getEmpId());
	        ps.setString(2, employees.get(i).getFirstName());
	        ps.setString(3, employees.get(i).getLastName()); 
	        ps.setDate(4, employees.get(i).getHireDate());
	        ps.setString(5, employees.get(i).getCity());
	        ps.setString(6, employees.get(i).getEmail());
	        ps.setString(7, employees.get(i).getPhoneNo());
	        
	      }
	                    
	      @Override
	      public int getBatchSize() {
	          return employees.size();
	      }
	    });            
	}

	@Override
	public void createEmployee(Employee employee) {
		
		final String INSERT_EMP_QUERY = "insert into employees (empId,firstName, lastName, hireDate, city, email, phoneNo) values ( ?, ?, ?, ?, ?, ?, ?) ";
		
		jdbcTemplate.update(INSERT_EMP_QUERY, employee.getEmpId(), employee.getFirstName(), employee.getLastName(), employee.getHireDate(), employee.getCity(), employee.getEmail(), employee.getPhoneNo());
		
		LOGGER.info(" Data inserted successfully");
		
	}

	@Override
	public Employee updateEmployee(long empId, Employee employee) {
		
		final String UPDATE_EMPLOYEE="update employees set firstName=?, lastName=?, hireDate=?, email=?, city=?, phoneNo=? where empId=?;";
		int size = jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getFirstName(), employee.getLastName(), employee.getHireDate(), employee.getEmail(), employee.getCity(), employee.getPhoneNo(), empId);
		
		if(size==0) {
			throw new ResourceNotFoundException("no employee with "+empId+" to update");
		}
		else {
			return employee;
		}
		
	}

}

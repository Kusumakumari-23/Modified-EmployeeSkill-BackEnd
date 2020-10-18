package com.employee.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.employee.demo.Repository.EmpRepositoryInterface;
import com.employee.demo.entity.Employee;
import com.employee.demo.exception.EmployeeSkillInsertionException;

@Service
public class EmpService implements EmpServiceInterface {

	@Autowired
	private EmpRepositoryInterface empRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.getAllEmployees();
	}
	
	@Override
	public Employee getEmployeeById(long empId) {
		
		return empRepo.getEmployeeById(empId);
	}
	
	/* INSERT BOTH SKILL AND EMPLOYEE */

	@Override
	@Transactional(isolation=Isolation.SERIALIZABLE, 
	               propagation= Propagation.REQUIRES_NEW,
	               rollbackFor= EmployeeSkillInsertionException.class)
	public Employee addEmployee(Employee employee) {
		
		try {
		return empRepo.addEmployee(employee);
		}catch(Exception e) {
			throw new EmployeeSkillInsertionException(" Internal Server Error");
		}
		
	}

	@Override
	public Employee updateEmployeeDetails(Employee employee) {
		
		return empRepo.updateEmployeeDetails(employee);
	}

	@Override
	@Transactional(isolation=Isolation.SERIALIZABLE, 
    propagation= Propagation.REQUIRES_NEW)
	public void deleteEmployeeDetails(long empId) {
		empRepo.deleteEmployeeDetails(empId);
		
	}

// batch Insert - inserting multiple records at a time

	@Override
	public int[] batchInsert(List<Employee> employees) {
		
		return empRepo.batchInsert(employees);
	}

	@Override
	public void createEmployee(Employee employee) {
		empRepo.createEmployee(employee);
		
	}

	@Override
	public Employee updateEmployee(long empId, Employee employee) {
		
		return empRepo.updateEmployee(empId, employee);
	}
}

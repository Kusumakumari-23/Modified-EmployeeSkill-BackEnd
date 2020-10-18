package com.employee.demo.Repository;

import java.util.List;

import com.employee.demo.entity.Employee;

public interface EmpRepositoryInterface {

    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    Employee updateEmployeeDetails(Employee employee);
    void deleteEmployeeDetails(long empId);
    Employee getEmployeeById(long empId);
    public void createEmployee(Employee employee);
    
    
    public int[] batchInsert(List<Employee> employees);
    Employee updateEmployee(long empId,Employee employee);
}

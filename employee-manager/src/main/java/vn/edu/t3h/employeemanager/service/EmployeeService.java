package vn.edu.t3h.employeemanager.service;

import vn.edu.t3h.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    List<Employee> findByFilter(String name,String salary,String fromDate,String toDate,String position);

    void addEmployeeService(int employee_id, String name, String position, double salary, int departmentID, String hireDate);

    void removeEmployeeService(int id);

    void updateEmployeeService(String name, String position, double salary, int departmentID, String hireDate, int id_int);

}

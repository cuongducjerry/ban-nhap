package vn.edu.t3h.employeemanager.dao;

import vn.edu.t3h.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployee();

    List<Employee> findByCondition(String name, String salary, String fromDate, String toDate, String position);

    void addEmployee(int employee_id, String name, String position, double salary, int departmentID, String hireDate);

    void removeEmployee(int employee_id);

    void updateEmployee(String name, String position, double salary, int departmentID, String hireDate, int id_int);

}
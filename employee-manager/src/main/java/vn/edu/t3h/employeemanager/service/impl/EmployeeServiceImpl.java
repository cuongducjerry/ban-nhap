package vn.edu.t3h.employeemanager.service.impl;

import com.mysql.cj.util.StringUtils;
import vn.edu.t3h.employeemanager.dao.EmployeeDao;
import vn.edu.t3h.employeemanager.model.Employee;
import vn.edu.t3h.employeemanager.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    /*
    EmployeeDao:
        chuyển được sử dụng để giao tiếp với database, giúp query dữ liệu từ database lên tầng
        app( java)
     */
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public List<Employee> findByFilter(String name, String salary, String fromDate, String toDate, String position) {

        if (StringUtils.isNullOrEmpty(name)){
            name = null;
        }
        if (StringUtils.isNullOrEmpty(salary)){
            salary = null;
        }
        if (StringUtils.isNullOrEmpty(fromDate)){
            fromDate = null;
        }
        if (StringUtils.isNullOrEmpty(toDate)){
            toDate = null;
        }
        if (StringUtils.isNullOrEmpty(position)){
            position = null;
        }
        List<Employee> employees = employeeDao.findByCondition(name, salary, fromDate, toDate, position);
        return employees;
    }

    @Override
    public void addEmployeeService(int employee_id, String name, String position, double salary, int departmentID, String hireDate) {
        employeeDao.addEmployee(employee_id, name, position, salary, departmentID, hireDate);
    }

    @Override
    public void removeEmployeeService(int id) {
        employeeDao.removeEmployee(id);
    }

    @Override
    public void updateEmployeeService(String name, String position, double salary, int departmentID, String hireDate, int id_int) {
        employeeDao.updateEmployee(name, position, salary, departmentID, hireDate, id_int);
    }


}

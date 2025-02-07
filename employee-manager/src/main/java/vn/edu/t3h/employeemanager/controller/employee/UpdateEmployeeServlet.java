package vn.edu.t3h.employeemanager.controller.employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.employeemanager.dao.EmployeeDao;
import vn.edu.t3h.employeemanager.dao.impl.EmployeeDaoMysqlImpl;
import vn.edu.t3h.employeemanager.model.Employee;
import vn.edu.t3h.employeemanager.service.EmployeeService;
import vn.edu.t3h.employeemanager.service.impl.EmployeeServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/update-employee")
public class UpdateEmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        super.init();
        // init bean, apply DI design pattern
        EmployeeDao employeeDao = new EmployeeDaoMysqlImpl();
        employeeService = new EmployeeServiceImpl(employeeDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String position = req.getParameter("position");
        String salary = req.getParameter("salary");
        double salaryDouble = Double.parseDouble(salary);
        String departmentID = req.getParameter("department_id");
        int departmentIDInt = Integer.parseInt(departmentID);
        String hireDate = req.getParameter("hire_date");
        String id = req.getParameter("id");
        int id_int = Integer.parseInt(id);

        employeeService.updateEmployeeService(name, position, salaryDouble, departmentIDInt, hireDate, id_int);

        List<Employee> employees = employeeService.getAllEmployee();
        req.setAttribute("employeeData",employees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("employees.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

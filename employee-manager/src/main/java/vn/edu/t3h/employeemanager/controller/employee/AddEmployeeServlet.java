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
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/action-employee")
public class AddEmployeeServlet extends HttpServlet {

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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-employee.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String position = req.getParameter("position");
        String salary = req.getParameter("salary");
        double salary2 = Double.parseDouble(salary);
        String departmentID = req.getParameter("department_id");
        int departmentID2 = Integer.parseInt(departmentID);
        String hireDate = req.getParameter("hire_date");

        List<Employee> employees = employeeService.getAllEmployee();
        int quantity = employees.size();
        int employeeID = quantity + 1;

        employeeService.addEmployeeService(employeeID, name, position, salary2, departmentID2, hireDate);

        List<Employee> employeeAfterAdd = employeeService.getAllEmployee();
        req.setAttribute("employeeData",employeeAfterAdd);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("employees.jsp");
        requestDispatcher.forward(req,resp);
    }
}

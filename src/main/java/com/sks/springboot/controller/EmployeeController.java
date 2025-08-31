package com.sks.springboot.controller;
import com.sks.springboot.entity.Employee;
import com.sks.springboot.service.EmployeeService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> theEmployee =  employeeService.findAll();
        model.addAttribute("employees", theEmployee);
        return "employees/list-employees";
    }

    /**
     * Show the form for adding a new employee.
     * @param model Model to hold employee object
     * @return add-employee view
     */
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/add-employee";
    }

    /**
     * Save a new employee submitted from the form.
     * @param employee Employee object from form
     * @return redirect to employee list
     */
    @RequestMapping("/save")
    public String saveEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    /**
     * Show the form for updating an existing employee.
     * @param employeeId ID of the employee to update
     * @param model Model to hold employee object
     * @return showFormForUpdate view
     */
    @GetMapping("/showFormForUpdate/{employeeId}")
    public String showFormForUpdate(@org.springframework.web.bind.annotation.PathVariable int employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        return "employees/showFormForUpdate";
    }

    /**
     * Show confirmation page for deleting an employee.
     * @param employeeId ID of the employee to delete
     * @param model Model to hold employee object
     * @return confirm-delete view
     */
    @GetMapping("/confirmDelete/{employeeId}")
    public String confirmDelete(@org.springframework.web.bind.annotation.PathVariable int employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        return "employees/confirm-delete";
    }

    /**
     * Delete an employee by ID (POST for confirmation).
     * @param employeeId ID of the employee to delete
     * @return redirect to employee list
     */
    @org.springframework.web.bind.annotation.PostMapping("/delete/{employeeId}")
    public String deleteEmployee(@org.springframework.web.bind.annotation.PathVariable int employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }
}
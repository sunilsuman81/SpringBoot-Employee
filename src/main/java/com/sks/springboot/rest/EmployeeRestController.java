package com.sks.springboot.rest;

import com.sks.springboot.entity.Employee;
import com.sks.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Get all employees.
     * @return List of all employees
     */
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    /**
     * Get an employee by ID.
     * @param employeeId Employee ID
     * @return Employee object if found, else null
     */
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {


        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    /**
     * Add a new employee.
     * @param employee Employee object to add
     * @return Saved Employee object
     */
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0); // Ensure new employee
        return employeeService.save(employee);
    }

    /**
     * Update an existing employee.
     * @param employee Employee object with updated data
     * @return Updated Employee object
     */
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    /**
     * Delete an employee by ID.
     * @param employeeId Employee ID
     */
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {


        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}

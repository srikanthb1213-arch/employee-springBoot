package org.example.employeeapp.Controller;

import org.example.employeeapp.Model.Employee;
import org.example.employeeapp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable  Long id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping()
    public Employee create(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable  Long id) {
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
         employeeService.deleteEmployeeById(id);
         return "Employee Deleted Successfully";
    }
}

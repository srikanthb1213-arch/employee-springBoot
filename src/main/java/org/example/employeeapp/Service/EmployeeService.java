package org.example.employeeapp.Service;

import org.example.employeeapp.Model.Employee;
import org.example.employeeapp.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee, Long id) {
        return employeeRepository.findById(id).map(emp->{
            emp.setFirstName(employee.getFirstName());
            emp.setEmail(employee.getEmail());
            emp.setlastName(employee.getLastName());
            return employeeRepository.save(emp);
        }).orElseThrow(()-> new RuntimeException("Employee Not Found"));
    }

   public void deleteEmployeeById(Long id) {
            employeeRepository.deleteById(id);
   }
}

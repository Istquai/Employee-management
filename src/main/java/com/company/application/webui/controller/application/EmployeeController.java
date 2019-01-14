package com.company.application.webui.controller.application;

import com.company.application.domain.service.EmployeeService;
import com.company.application.webui.controller.Mappings;
import com.company.application.webui.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Mappings.EMPLOYEE)
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(@RequestBody EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void addEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.addEmployee(employeeDto);
    }

    @GetMapping
    public List<EmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/search")
    public List<EmployeeDto> search(@RequestBody EmployeeDto employeeDto){
        return employeeService.findEmployee(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
}

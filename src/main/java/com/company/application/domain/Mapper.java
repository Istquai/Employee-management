package com.company.application.domain;

import com.company.application.domain.model.Employee;
import com.company.application.webui.dto.EmployeeDto;

public class Mapper {

    public static EmployeeDto mapToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setPositionId(employee.getPosition().getId());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        return employeeDto;
    }

    private Mapper() {

    }
}

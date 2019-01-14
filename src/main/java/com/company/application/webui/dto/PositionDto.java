package com.company.application.webui.dto;

import java.util.List;

public class PositionDto {

    private int positionId;
    private List<EmployeeDto> employeeDtos;
    private String name;

    public PositionDto() {
    }

    public PositionDto(int positionId, List<EmployeeDto> employeeDtos, String name) {
        this.positionId = positionId;
        this.employeeDtos = employeeDtos;
        this.name = name;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public List<EmployeeDto> getEmployeeDtos() {
        return employeeDtos;
    }

    public void setEmployeeDtos(List<EmployeeDto> employeeDtos) {
        this.employeeDtos = employeeDtos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

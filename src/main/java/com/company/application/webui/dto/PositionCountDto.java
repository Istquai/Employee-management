package com.company.application.webui.dto;

public class PositionCountDto {
    private String positionName;
    private int employeeCount;

    public PositionCountDto() {
    }

    public PositionCountDto(String positionName, int employeeCount) {
        this.positionName = positionName;
        this.employeeCount = employeeCount;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
}

package com.SeatReservation.SeatReservation;

public class Employee {
    private String employeeId;
    private String team;

    public Employee(String employeeId, String team) {
        this.employeeId = employeeId;
        this.team = team;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getTeam() {
        return team;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
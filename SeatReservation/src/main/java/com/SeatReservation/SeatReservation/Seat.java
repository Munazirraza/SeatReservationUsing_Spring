package com.SeatReservation.SeatReservation;

import java.time.LocalDate;

public class Seat {
    private String seatNo;
    private String employeeId;
    private LocalDate date;

    public Seat(String seatNo, String employeeId, LocalDate date) {
        this.seatNo = seatNo;
        this.employeeId = employeeId;
        this.date = date;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

package com.SeatReservation.SeatReservation;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SeatController {
    private final List<Seat> seatList = new ArrayList<>();
    private final Map<String, Employee> employeeMap = new HashMap<>();

    @PostMapping("/seats")
    public Seat addSeat(@RequestBody Seat seat) {
        seatList.add(seat);
        return seat;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeMap.put(employee.getEmployeeId(), employee);
        return employee;
    }

    @GetMapping("/seats/vacant")
    public int getVacantSeatsCount(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        long occupiedSeats = seatList.stream()
                .filter(seat -> seat.getDate().equals(date))
                .count();
        return (int) (100 - occupiedSeats); // Assuming there are 100 seats in total
    }

    @GetMapping("/employees/count")
    public int getEmployeesCountMoreThanFiveVisits() {
        Map<String, Long> employeeVisitsCount = seatList.stream()
                .collect(Collectors.groupingBy(Seat::getEmployeeId, Collectors.counting()));

        return (int) employeeVisitsCount.values().stream()
                .filter(count -> count > 5)
                .count();
    }

    @GetMapping("/teams/max-visited")
    public String getTeamWithMaxVisitsMoreThanTen() {
        Map<String, Long> teamVisitsCount = seatList.stream()
                .collect(Collectors.groupingBy(
                        seat -> employeeMap.get(seat.getEmployeeId()).getTeam(),
                        Collectors.counting()
                ));

        long maxVisits = 10; // Minimum visits required
        String teamWithMaxVisits = null;
        for (Map.Entry<String, Long> entry : teamVisitsCount.entrySet()) {
            if (entry.getValue() > maxVisits) {
                maxVisits = entry.getValue();
                teamWithMaxVisits = entry.getKey();
            }
        }

        return teamWithMaxVisits;
    }
}
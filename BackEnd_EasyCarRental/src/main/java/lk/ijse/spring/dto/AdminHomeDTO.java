package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminHomeDTO {
    private String regUsers;
    private String totalBookings;
    private String bookingsPerDay;
    private String workingDrivers;
    private String totalCars;
    private String rentedCars;
    private String availableCar;
    private String recievedCar;
}

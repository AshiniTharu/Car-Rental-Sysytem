package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminHome {
    @Id
    private String regUsers;
    private String totalBookings;
    private String bookingsPerDay;
    private String workingDrivers;
    private String totalCars;
    private String rentedCars;
    private String availableCar;
    private String recievedCar;
}

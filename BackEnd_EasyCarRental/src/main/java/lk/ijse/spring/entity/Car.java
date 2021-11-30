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
public class Car {
    @Id
    private String regNumber;
    private String brand;
    private String type;
    private String numOfPassengers;
    private String transmissionType;
    private String fuelType;
    private String colour;
    private String dailyRent;
    private String mounthlyRent;
    private String freeMillage;
    private String exKmPrice;
    private String dmgfee;
}

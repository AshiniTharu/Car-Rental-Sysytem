package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {
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

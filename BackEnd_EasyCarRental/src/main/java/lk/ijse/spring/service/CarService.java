package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;
import org.springframework.stereotype.Service;

public interface CarService {
    boolean saveCar(CarDTO carDTO);

    boolean updateCar(CarDTO carDTO);

    boolean deleteCar(String RegNo);

    CarDTO searchCarByBrand(String brand);

    CarDTO searchCarByColour(String colour);

    CarDTO searchCarByTypeTransType(String trans);

    CarDTO searchCarpFuelType(String fuel);
}

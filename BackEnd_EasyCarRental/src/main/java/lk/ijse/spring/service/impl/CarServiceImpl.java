package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CarRepo carRepo;
    @Override
    public boolean saveCar(CarDTO carDTO) {
        carRepo.save(mapper.map(carDTO, Car.class));
        return true;

    }

    @Override
    public boolean updateCar(CarDTO carDTO) {
        return false;
    }

    @Override
    public boolean deleteCar(String RegNo) {
        return false;
    }

    @Override
    public CarDTO searchCarByBrand(String brand) {
        return null;
    }

    @Override
    public CarDTO searchCarByColour(String colour) {
        return null;
    }

    @Override
    public CarDTO searchCarByTypeTransType(String trans) {
        return null;
    }

    @Override
    public CarDTO searchCarpFuelType(String fuel) {
        return null;
    }
}

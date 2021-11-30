package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.StandradResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;

@RestController
@RequestMapping("/Car")
@CrossOrigin
@MultipartConfig
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping(path = "/savecar")
    public ResponseEntity saveCar(@RequestBody CarDTO carDTO){
        carService.saveCar(carDTO);
        return new ResponseEntity(new StandradResponse("201", "Done", carDTO), HttpStatus.CREATED);
    }
}

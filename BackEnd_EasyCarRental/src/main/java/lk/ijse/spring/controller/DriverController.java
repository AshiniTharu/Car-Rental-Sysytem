package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverLoginDTO;
import lk.ijse.spring.entity.DriverLogin;
import lk.ijse.spring.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;

@RestController
@RequestMapping("/driver")
@CrossOrigin
@MultipartConfig
public class DriverController {

    @Autowired
    private DriverService driverService;


    @PostMapping(path = "/driverLogin")
    public ModelAndView driverLogin(@RequestBody String uname,String psw){
        return driverService.findByDriverUnameAndDriverPword(uname,psw);
    }
}

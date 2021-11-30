package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerLoginDTO;
import lk.ijse.spring.dto.DriverLoginDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


public interface DriverService {
    boolean saveDriverLoginInfo(DriverLoginDTO driverLoginDTO);

    ModelAndView findByDriverUnameAndDriverPword(String driverUname, String driverPword);

}

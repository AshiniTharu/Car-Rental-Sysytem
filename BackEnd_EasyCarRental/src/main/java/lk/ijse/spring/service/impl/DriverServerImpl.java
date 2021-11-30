package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverLoginDTO;
import lk.ijse.spring.repo.DriverLoginRepo;
import lk.ijse.spring.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DriverServerImpl implements DriverService
{
    @Autowired
    private DriverLoginRepo driverLoginRepo;

    @Autowired
    private ModelAndView modelAndView;

    @Override
    public boolean saveDriverLoginInfo(DriverLoginDTO driverLoginDTO) {
        return false;
    }

    @Override
    public ModelAndView findByDriverUnameAndDriverPword(String driverUname, String driverPword) {
        Optional<ModelAndView> driver = driverLoginRepo.findByDriverUnameAndDriverPword(driverUname, driverPword);
        if(driver.isPresent()){
            modelAndView.setViewName("LoginHome");
            return modelAndView;
        }
        return null;
    }




}

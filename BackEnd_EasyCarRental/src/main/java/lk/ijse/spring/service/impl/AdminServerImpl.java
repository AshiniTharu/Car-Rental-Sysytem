package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminHomeDTO;
import lk.ijse.spring.dto.BookingDetailDTO;
import lk.ijse.spring.dto.BookingReqDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.AdminLogin;
import lk.ijse.spring.entity.BookingDetails;
import lk.ijse.spring.entity.BookingReq;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.AdminLogingRepo;
import lk.ijse.spring.repo.BookingDetailRepo;
import lk.ijse.spring.repo.BookingReqRepo;
import lk.ijse.spring.service.AdminHomeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServerImpl implements AdminHomeService {

    @Autowired
    private AdminLogingRepo adminLogingRepo;

    @Autowired
    private ModelAndView modelAndView;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean saveAdminHomeDetails(AdminHomeDTO adminHomeDTO) {
        return false;
    }

    @Override
    public boolean updateAdminHomeDetails(AdminHomeDTO adminHomeDTO) {
        return false;
    }

    /*@Override
    public boolean findByUsernameAndPassword(String uname, String psw) {
        Optional<AdminLogin> admin = adminLogingRepo.findByUsernameAndPassword(uname, psw);
        if(admin.isPresent()){
            modelAndView.setViewName("LoginHome");
            return modelAndView;
        }return null;
    }*/
    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        /*Optional<AdminLogin> admin = AdminLogingRepo.findByUsernameAndPassword(username, password);
        if(admin.isPresent()){
            //modelAndView.setViewName("LoginHome");
            return  true;
        }*/
        return false;
    }


}

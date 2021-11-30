package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminHomeDTO;
import lk.ijse.spring.dto.BookingDetailDTO;
import lk.ijse.spring.dto.BookingReqDTO;
import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

public interface AdminHomeService {
    boolean saveAdminHomeDetails(AdminHomeDTO adminHomeDTO);

    boolean updateAdminHomeDetails(AdminHomeDTO adminHomeDTO );

    boolean findByUsernameAndPassword(String uname,String psw);

}

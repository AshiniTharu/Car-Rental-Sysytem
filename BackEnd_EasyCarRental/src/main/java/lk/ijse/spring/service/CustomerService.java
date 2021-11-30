package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerLoginDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.CustomerLogin;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    //  ModelAndView checkCustomerPersonalDetails(CustomerDTO customerDTO);

    boolean saveCustomerPersonalInfo(CustomerDTO customerDTO);

    ModelAndView saveCustomerAllInfo(CustomerDTO customerDTO);

    ModelAndView saveCustomerLoginInfo(CustomerLoginDTO customerLoginDTO);

    boolean updateCustomerLoginInfo(CustomerLoginDTO customerLoginDTO);

    boolean updateCustomerPersonalInfo(CustomerDTO customerDTO);

    ArrayList<CustomerDTO> getAllCustomers();

/*
    ModelAndView findByUsernameAndPassword(String username, String password);
*/

  //  boolean findByNic(String nic);

    boolean saveNewCustomerAllInfo(CustomerDTO customerDTO);

    boolean findByUsernameAndPassword(String uname, String psw);


}

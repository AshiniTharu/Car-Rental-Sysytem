package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerLoginDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.CustomerLogin;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.CustomerLoginRepo;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    CustomerLoginRepo customerLoginRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ModelAndView modelAndView;

    /*//next click krma customer innwd ndd kyl chek krl innw nm excep ek ywnw.nthnm login info ekt ywnw
    @Override
    public ModelAndView checkCustomerPersonalDetails(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getNic())) {
            throw new RuntimeException("You are Already Registered");
        }
        modelAndView.setViewName("registration_3");
        return modelAndView;
    }*/

    //customer log wenkt ey reguna knkda kyl check krla blala log wela nm login home ekt ynna
    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        Optional<Customer> customer = customerRepo.findByUsernameAndPassword(username, password);
    if(customer.isPresent()){
        //modelAndView.setViewName("LoginHome");
        return  true;
    }
    return false;
    }

    @Override
    public boolean saveNewCustomerAllInfo(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getNic())) {
            throw new ValidateException("You are Already Registered");
        }
        customerRepo.save(mapper.map(customerDTO, Customer.class));

        modelAndView.setViewName("registration_3");

        return true;    }


    @Override
    public boolean saveCustomerPersonalInfo(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getNic())) {
            throw new ValidateException("You are Already Registered");
        }
        customerRepo.save(mapper.map(customerDTO, Customer.class));
        return true;

    }

    //save click krma innwnm excep ek ywnw.nthnm login info ekt ynw
    @Override
    public ModelAndView saveCustomerAllInfo(CustomerDTO customerDTO) {
       return null;
    }

    //login info save wenw.check rnn dyk ne mkd login info ekt enna denne new user knkta withari nisa
    @Override
    public ModelAndView saveCustomerLoginInfo(CustomerLoginDTO customerLoginDTO) {
        if(customerLoginRepo.existsById(customerLoginDTO.getUsername())){
            throw new ValidateException("UserName is Already gone.pleace use another");
        }
        customerLoginRepo.save(mapper.map(customerLoginDTO,CustomerLogin.class));
        modelAndView.setViewName("carList");

        return modelAndView;    }

    @Override
    public boolean updateCustomerLoginInfo(CustomerLoginDTO customerLoginDTO) {
        return false;
    }

    @Override
    public boolean updateCustomerPersonalInfo(CustomerDTO customerDTO) {
        return false;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }


    /*@Override
    public boolean findByNic(String nic) {
        Optional<Customer> customer = customerRepo.findByNic(nic);
        if(customer.isPresent()){
            throw new RuntimeException("You are Already Registered");
        }
        customerRepo.save(mapper.map(customer.get(), Customer.class));
        return true;      }*/

}


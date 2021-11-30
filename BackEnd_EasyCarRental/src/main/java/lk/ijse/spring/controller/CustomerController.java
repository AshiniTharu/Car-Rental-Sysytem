package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerLoginDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.CustomerLogin;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/customer")
@CrossOrigin
@MultipartConfig
public class CustomerController {
   @Autowired
    private CustomerService customerService;

   @Autowired
   private ModelAndView modelAndView;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCustomers() {
        ArrayList<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity(new StandradResponse("200", "Done", allCustomers), HttpStatus.OK);
    }

    @PostMapping(path = "/savePersonalInfo",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_HTML_VALUE)
    public String saveCustomerPersonalInfo(@RequestBody CustomerDTO customerDTO){
       if(customerDTO.getNic().length()<=0){
            throw new NotFoundException("Customer NIC cannot be empty");
        }
        customerService.saveNewCustomerAllInfo(customerDTO);
       /*modelAndView.setViewName("carList");
       return modelAndView;*/
       return customerDTO.toString();
        //return new ResponseEntity(new StandradResponse("201", "Done", customerDTO), HttpStatus.CREATED);
    }


        @PutMapping(path = "/updateLoginInfo")
        public ResponseEntity updateCustomerLoginInfo(@RequestBody CustomerLoginDTO customerLoginDTO){
          /*  if(customerLoginDTO.getUsername().trim().length()<=0){
                throw new NotFoundException("No NIC provided to update");
            }
            customerService.updateCustomerLoginInfo(customerLoginDTO);
            return new ResponseEntity(new StandradResponse("200","Done",customerLoginDTO),HttpStatus.OK);*/
          return null;
        }

    @PutMapping(path = "/updatePersonalInfo")
    public String  updateCustomerPersonalInfo(@RequestBody CustomerDTO customerDTO){
       if(customerDTO.getNic().trim().length()<=0){
            throw new NotFoundException("No NIC provided to update");
        }
        boolean b = customerService.updateCustomerPersonalInfo(customerDTO);
       return b+"";
        // return new ResponseEntity(new StandradResponse("200","Done",customerDTO),HttpStatus.OK);

    }

    @PostMapping(path ="/login/{username}/{password}")
    public ResponseEntity checkUserforSignIn(@PathVariable String username, @PathVariable String password){
        boolean customer = customerService.findByUsernameAndPassword(username, password);
      //  modelAndView.setViewName("carList");
        return new ResponseEntity(new StandradResponse("201","Done",customer), HttpStatus.MULTI_STATUS.CREATED);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveFile(@RequestPart("file") MultipartFile myFile) {        //Catch the file from the request
        /*
         * There are three ways we can obtain this value, but in all cases we need to use
         * @RequestPart annotation.
         * 1. Byte Array ( byte [] )
         * 2. MultipartFile ( Spring way )
         * 3. Part ( Java EE way )
         */
        //  01.First we need to configure MultipartResolver
        //  02.We need to override  method inorder to set MultipartConfigElement
        //  Check WebAppConfig and WebAppInitializer
        //  In spring boot we dont need to add those two configurations

        System.out.println(myFile.getOriginalFilename());;

        try {
            // Let's get the project location
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            // Let's create a folder there for uploading purposes, if not exists
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();
            // It is time to transfer the file into the newly created dir
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



}

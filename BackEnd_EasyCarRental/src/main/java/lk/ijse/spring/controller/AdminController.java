package lk.ijse.spring.controller;

import lk.ijse.spring.dto.*;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.service.AdminHomeService;
import lk.ijse.spring.service.PlaceBookingService;
import lk.ijse.spring.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminHomeService adminHomeService;

    @Autowired
    private PlaceBookingService placeBookingService;

    /*@PostMapping(path = "/adminLogin")
    public ModelAndView adminlogin(String uname,String psw){
        return adminHomeService.findByUsernameAndPassword(uname,psw);
    }*/

    @PostMapping(path ="/login/{aUsername}/{aPassword}")
    public ResponseEntity checkUserforSignIn(@PathVariable String username, @PathVariable String password){
        boolean admin = adminHomeService.findByUsernameAndPassword(username, password);
        //  modelAndView.setViewName("carList");
        return new ResponseEntity(new StandradResponse("201","Done",admin), HttpStatus.MULTI_STATUS.CREATED);
    }


    @GetMapping(path = "req",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllBookingRequests() {
        ArrayList<BookingReqDTO> allRequests = placeBookingService.getAllBookingReq();
        return new ResponseEntity(new StandradResponse("200", "Done", allRequests), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllBookingDetails() {
        ArrayList<BookingDetailDTO> allDetails = placeBookingService.getAllBookingDetails();
        return new ResponseEntity(new StandradResponse("200", "Done", allDetails), HttpStatus.OK);
    }

}

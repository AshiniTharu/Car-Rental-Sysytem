package lk.ijse.spring.controller;

import lk.ijse.spring.dto.BookingReqDTO;
import lk.ijse.spring.service.PlaceBookingService;
import lk.ijse.spring.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/book")
@CrossOrigin
@MultipartConfig
public class BookingController {
    @Autowired
    private PlaceBookingService placeBookingService;

    @PostMapping(path = "/save")


    public ResponseEntity saveOrders(@RequestBody BookingReqDTO dto) {
        System.out.println(dto);
        placeBookingService.placeBooking(dto);

       return new ResponseEntity(new StandradResponse("201", "Done", dto), HttpStatus.CREATED);
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

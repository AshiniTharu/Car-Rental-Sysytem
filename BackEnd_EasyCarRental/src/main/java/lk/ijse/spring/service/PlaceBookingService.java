package lk.ijse.spring.service;

import lk.ijse.spring.dto.BookingDetailDTO;
import lk.ijse.spring.dto.BookingReqDTO;

import java.util.ArrayList;

public interface PlaceBookingService {
    void placeBooking(BookingReqDTO dto);

    ArrayList<BookingDetailDTO> getAllBookingDetails();

    ArrayList<BookingReqDTO> getAllBookingReq();

}

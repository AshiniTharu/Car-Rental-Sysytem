package lk.ijse.spring.dto;

import lk.ijse.spring.entity.BookingDetails;
import lk.ijse.spring.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingReqDTO {
    private String bookingId;
    private String date;
    private Customer customerID;
    private List<BookingDetailDTO> bookingDetails = new ArrayList<>();
    private BookingDetails driverissue;
    private BookingDetails enddate;
    private BookingDetails startdate;
}

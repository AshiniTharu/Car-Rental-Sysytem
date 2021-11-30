package lk.ijse.spring.dto;


import lk.ijse.spring.entity.BookingReq;
import lk.ijse.spring.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDetailDTO {
    private Car_BookingDetail_PK_DTO car_bookingDetail_pk;
    private String startTime;
    private String endTime;
    private String driverIssue;
    private BookingReq bookingId;
    private Car regNumber;
}

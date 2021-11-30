package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDetails{
    @EmbeddedId
    private Car_BookingDetail_PK car_bookingDetail_pk;
    private String startTime;
    private String endTime;
    private String driverIssue;
    @ManyToOne
    @JoinColumn(name = "bookingId",referencedColumnName = "bookingId",insertable = false,updatable = false)
    private BookingReq bookingId;
    @ManyToOne
    @JoinColumn(name = "regNumber",referencedColumnName = "regNumber",insertable = false,updatable = false)
    private Car regNumber;
}

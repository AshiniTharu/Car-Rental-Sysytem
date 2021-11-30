package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car_BookingDetail_PK_DTO implements Serializable {
    private String bookingId;
    private String regNumber;
}

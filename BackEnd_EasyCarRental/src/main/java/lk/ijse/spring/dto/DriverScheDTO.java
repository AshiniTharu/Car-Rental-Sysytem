package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverScheDTO {
    private String dId;
    private String dName;
    private LocalDateTime StartDateTime;
    private LocalDateTime EndDateTime;

}

package lk.ijse.spring.util;

import lk.ijse.spring.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandradResponse {
    private String code;
    private String message;
    private Object data;
}

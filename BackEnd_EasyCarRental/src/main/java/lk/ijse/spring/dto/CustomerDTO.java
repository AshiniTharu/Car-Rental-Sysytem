package lk.ijse.spring.dto;

import lk.ijse.spring.entity.CustomerLogin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String email;
    private String nic;
    private String address;
    private String contact;
    private String username;
    private String password;
    }

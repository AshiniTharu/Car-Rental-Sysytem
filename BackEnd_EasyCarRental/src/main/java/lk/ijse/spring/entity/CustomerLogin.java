package lk.ijse.spring.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerLogin {
    @Id
    private String username;
    private String password;
    private LocalDateTime dateTime;
    @OneToOne
    private Customer customer;

}

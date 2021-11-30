package lk.ijse.spring.entity;

import com.sun.istack.NotNull;
import lk.ijse.spring.dto.CustomerLoginDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(
        name = "customer",
        uniqueConstraints = {@UniqueConstraint(columnNames = "username")}
)
public class Customer {
    @NotNull
    private String email;
    @Id
    @NotNull
    private String nic;
    @NotNull
    private String address;
    @NotNull
    private String contact;
    @NotNull
    private String username;
    @NotNull
    private String password;
}

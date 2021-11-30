package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingReq {
    @Id
    private String bookingId;
    private String date;
    @ManyToOne
    @JoinColumn(name="CustomerNic",referencedColumnName = "nic")
    private Customer customerID;
    @OneToMany(mappedBy = "bookingId",cascade = CascadeType.ALL)
    private List<BookingDetails> bookingDetails=new ArrayList<>();

}

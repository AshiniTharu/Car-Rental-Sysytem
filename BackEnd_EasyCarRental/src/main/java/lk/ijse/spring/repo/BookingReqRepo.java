package lk.ijse.spring.repo;

import lk.ijse.spring.entity.BookingReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingReqRepo extends JpaRepository <BookingReq,String>{
}

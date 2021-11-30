package lk.ijse.spring.repo;

import lk.ijse.spring.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailRepo extends JpaRepository<BookingDetails,String> {
}

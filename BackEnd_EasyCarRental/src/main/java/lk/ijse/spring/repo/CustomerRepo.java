package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {
   // Optional<Customer> findByNic(String nic);
    Optional<Customer> findByUsernameAndPassword(String uname, String psw);

}

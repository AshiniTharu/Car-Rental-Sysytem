package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.CustomerLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerLoginRepo extends JpaRepository<CustomerLogin,String> {
    Optional<CustomerLogin> findByUsernameAndPassword(String username, String password);
}

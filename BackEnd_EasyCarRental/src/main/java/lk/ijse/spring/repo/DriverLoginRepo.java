package lk.ijse.spring.repo;

import lk.ijse.spring.entity.DriverLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
public interface DriverLoginRepo extends JpaRepository<DriverLogin,String> {
    Optional<ModelAndView> findByDriverUnameAndDriverPword(String driverUname, String driverPword);

}

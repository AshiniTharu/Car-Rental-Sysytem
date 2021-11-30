package lk.ijse.spring.repo;

import lk.ijse.spring.entity.AdminLogin;
import lk.ijse.spring.entity.CustomerLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminLogingRepo extends JpaRepository<AdminLogin,String> {
   Optional<AdminLogin> findByUsernameAndPassword(String username, String password);

}

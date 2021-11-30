package lk.ijse.spring.repo;

import lk.ijse.spring.entity.DriverSche;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DriverScheRepo extends JpaRepository<DriverSche,String> {
}

package lk.java.springboot.academy.Demo.Repository;

import lk.java.springboot.academy.Demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Integer>{

}

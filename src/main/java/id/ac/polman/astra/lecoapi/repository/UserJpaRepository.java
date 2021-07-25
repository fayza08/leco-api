package id.ac.polman.astra.lecoapi.repository;

import id.ac.polman.astra.lecoapi.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository("UserJpaRepository")
public interface UserJpaRepository extends JpaRepository<User, Serializable> {
//    User findByIdEqualsOrStatus();

    List<User> findAll();

    @Query("select a from User a where a.email=:email AND a.password=:password AND a.status =0")
    public Optional<User> Login(@Param("email") String email, @Param("password") String password);
}

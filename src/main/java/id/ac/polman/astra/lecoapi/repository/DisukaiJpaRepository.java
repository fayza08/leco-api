package id.ac.polman.astra.lecoapi.repository;

import id.ac.polman.astra.lecoapi.vo.Disukai;
import id.ac.polman.astra.lecoapi.vo.Resep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("DisukaiJpaRepository")
public interface DisukaiJpaRepository extends JpaRepository<Disukai, Serializable> {
    List<Disukai> findAll();

    @Query("SELECT r FROM Resep r, Disukai d WHERE r.Id = d.Id_resep and d.Id_user = ?1")
    List<Resep> findById_user(Integer id_user);
}

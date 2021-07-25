package id.ac.polman.astra.lecoapi.repository;

import id.ac.polman.astra.lecoapi.vo.Resep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("ResepJpaRepository")
public interface ResepJpaRepository extends JpaRepository<Resep, Serializable> {
    List<Resep> findAll();

    @Query("SELECT r FROM Resep r WHERE r.Id = ?1")
    Resep findById(Integer id);

    @Query("SELECT r FROM Resep r WHERE r.Id_user = ?1 AND r.status = 0")
    List<Resep> findById_userIsLikeAndStatus(Integer id_user);

//    List<Resep> findById_userIsLike(Integer id);
}

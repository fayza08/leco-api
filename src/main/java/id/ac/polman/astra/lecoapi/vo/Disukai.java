package id.ac.polman.astra.lecoapi.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "disukai")
public class Disukai {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_resep")
    private Integer Id_resep;

    @Column(name = "id_user")
    private Integer Id_user;

    @Column(name = "tanggal")
    private String tanggal;

    public Disukai(Integer id, Integer id_resep, Integer id_user, String tanggal) {
        this.id = id;
        Id_resep = id_resep;
        Id_user = id_user;
        this.tanggal = tanggal;
    }

    public Disukai() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getId_resep() {
        return Id_resep;
    }

    public void setId_resep(Integer id_resep) {
        Id_resep = id_resep;
    }

    public Integer getId_user() {
        return Id_user;
    }

    public void setId_user(Integer id_user) {
        Id_user = id_user;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}

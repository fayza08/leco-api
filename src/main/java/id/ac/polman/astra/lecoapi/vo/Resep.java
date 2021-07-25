package id.ac.polman.astra.lecoapi.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resep")
public class Resep {

    @Id
    @Column(name = "id")
    private Integer Id;

    @Column(name = "id_user")
    private Integer Id_user;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alat_bahan")
    private String alat_bahan;

    @Column(name = "tahap")
    private String tahap;

    @Column(name = "nilai")
    private Integer nilai;

    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "foto")
    private String foto;

    @Column(name = "status")
    private Integer status;

    public Resep(Integer id, Integer id_user, String nama, String alat_bahan, String tahap, Integer nilai, String keterangan, String foto, Integer status) {
        Id = id;
        Id_user = id_user;
        this.nama = nama;
        this.alat_bahan = alat_bahan;
        this.tahap = tahap;
        this.nilai = nilai;
        this.keterangan = keterangan;
        this.foto = foto;
        this.status = status;
    }

    public Resep() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getId_user() {
        return Id_user;
    }

    public void setId_user(Integer id_user) {
        Id_user = id_user;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlat_bahan() {
        return alat_bahan;
    }

    public void setAlat_bahan(String alat_bahan) {
        this.alat_bahan = alat_bahan;
    }

    public String getTahap() {
        return tahap;
    }

    public void setTahap(String tahap) {
        this.tahap = tahap;
    }

    public Integer getNilai() {
        return nilai;
    }

    public void setNilai(Integer nilai) {
        this.nilai = nilai;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

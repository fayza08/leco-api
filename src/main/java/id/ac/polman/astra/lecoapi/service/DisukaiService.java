package id.ac.polman.astra.lecoapi.service;

import id.ac.polman.astra.lecoapi.repository.DisukaiJpaRepository;
import id.ac.polman.astra.lecoapi.repository.ResepJpaRepository;
import id.ac.polman.astra.lecoapi.vo.Disukai;
import id.ac.polman.astra.lecoapi.vo.Resep;
import id.ac.polman.astra.lecoapi.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisukaiService {
    @Qualifier("DisukaiJpaRepository")
    @Autowired
    DisukaiJpaRepository mDisukaiJpaRepository;

    @Qualifier("ResepJpaRepository")
    @Autowired
    ResepJpaRepository mResepJpaRepository;


    public List<Disukai> getDisukais(){
        List<Disukai> disukais = mDisukaiJpaRepository.findAll();
        return disukais;
    }

    public List<Resep> getHistory(Integer id){
        List<Resep> disukais = mDisukaiJpaRepository.findById_user(id);
        return disukais;
    }

    public boolean saveDisukai(Disukai disukai){
        disukai.setId(0);
        Disukai result = mDisukaiJpaRepository.save(disukai);
        boolean isSuccess = true;
        updateResep(disukai.getId_resep());
        if(result == null){
            isSuccess = false;
        }

        return isSuccess;
    }

    private void updateResep(Integer id){
        Resep resep = mResepJpaRepository.findById(id);
        int nilai = resep.getNilai() + 1;
        resep.setNilai(nilai);

        mResepJpaRepository.save(resep);
    }

    public boolean deleteDisukai(Integer id){
        Disukai result = mDisukaiJpaRepository.getById(id);

        if(result == null){
            return false;
        }
        mDisukaiJpaRepository.delete(result);
        return true;
    }
}

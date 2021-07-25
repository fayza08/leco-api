package id.ac.polman.astra.lecoapi.service;

import id.ac.polman.astra.lecoapi.repository.ResepJpaRepository;
import id.ac.polman.astra.lecoapi.vo.Resep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResepService {
    @Qualifier("ResepJpaRepository")
    @Autowired
    ResepJpaRepository mResepJpaRepository;

//    public Resep getResepId(Integer id){
//        Resep resep = mResepJpaRepository.getById(id);
//        return resep;
//    }

    public Resep getResepId(Integer id){
        Resep resep = mResepJpaRepository.findById(id);
        return resep;
    }

    public List<Resep> getResepIdUser(Integer id){
        List<Resep> resep = mResepJpaRepository.findById_userIsLikeAndStatus(id);
        return resep;
    }

    public List<Resep> getReseps(){
        List<Resep> resepList = mResepJpaRepository.findAll();
        return resepList;
    }

    public boolean saveResep(Resep resep){
        Resep result = mResepJpaRepository.save(resep);
        boolean isSuccess = true;

        if(result == null){
            isSuccess = false;
        }

        return isSuccess;
    }

    public boolean deleteResep(Integer id){
        Resep result = mResepJpaRepository.getById(id);

        if(result == null){
            return false;
        }

        result.setStatus(1);
        mResepJpaRepository.save(result);
        return true;
    }
}

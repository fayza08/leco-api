package id.ac.polman.astra.lecoapi.service;

import id.ac.polman.astra.lecoapi.repository.UserJpaRepository;
import id.ac.polman.astra.lecoapi.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Qualifier("UserJpaRepository")
    @Autowired
    UserJpaRepository mUserJpaRepository;

    public Optional<User> getUser(Integer id){
        Optional<User> user = mUserJpaRepository.findById(id);
        return user;
    }

    public Optional<User> getLogin(String email, String password){
        Optional<User> user = mUserJpaRepository.Login(email, password);
        return user;
    }

    public List<User> getUsers(){
        List<User> userList = mUserJpaRepository.findAll();
        return userList;
    }

    public boolean saveUser(User user){
        User result = mUserJpaRepository.save(user);
        boolean isSuccess = true;

        if(result == null){
            isSuccess = false;
        }

        return isSuccess;
    }

    public boolean deleteUser(Integer id){
        User result = mUserJpaRepository.getById(id);

        if(result == null){
            return false;
        }

        result.setStatus(1);
        mUserJpaRepository.save(result);
        return true;
    }
}

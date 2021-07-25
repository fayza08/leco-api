package id.ac.polman.astra.lecoapi.Controller;

import id.ac.polman.astra.lecoapi.service.UserService;
import id.ac.polman.astra.lecoapi.vo.Result;
import id.ac.polman.astra.lecoapi.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService mUserService;

    @GetMapping("/user")
    public Optional<User> getUser(@RequestParam("id") Integer id){
        Optional<User> user = mUserService.getUser(id);
        return user;
    }

    @GetMapping("/login")
    public Optional<User> getLogin(@RequestParam("email") String email, @RequestParam("password") String password){
        Optional<User> user = mUserService.getLogin(email, password);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> userList = mUserService.getUsers();
        return userList;
    }

    @PostMapping("/user")
    public Object saveUser(HttpServletResponse response, @RequestBody User userParam){
        User user = new User(0, userParam.getNama(), userParam.getEmail(), userParam.getPassword(), 0);
        boolean isSuccess = mUserService.saveUser(user);

        if(isSuccess){
            return new Result(200, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }

    @PutMapping("/user")
    public Object modifyUser(HttpServletResponse response, @RequestBody User userParam){
        User user = new User(userParam.getId(), userParam.getNama(), userParam.getEmail(), userParam.getPassword(), 0);
        boolean isSuccess = mUserService.saveUser(user);

        if(isSuccess){
            return new Result(200,"Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500,"Fail");
        }
    }

    @DeleteMapping("/user")
    public Object deleteUser(HttpServletResponse response, @RequestParam("id") Integer id){
        boolean isSuccess = mUserService.deleteUser(id);

        if(isSuccess){
            return new Result(200,"Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }
}

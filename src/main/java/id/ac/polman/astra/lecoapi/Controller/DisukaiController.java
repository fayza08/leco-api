package id.ac.polman.astra.lecoapi.Controller;

import id.ac.polman.astra.lecoapi.service.DisukaiService;
import id.ac.polman.astra.lecoapi.vo.Disukai;
import id.ac.polman.astra.lecoapi.vo.Resep;
import id.ac.polman.astra.lecoapi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class DisukaiController {
    @Autowired
    DisukaiService mDisukaiService;

    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String tgl = DateFor.format(date);

    @GetMapping("/disukais")
    public List<Disukai> getDisukai(){
        List<Disukai> disukais = mDisukaiService.getDisukais();
        return disukais;
    }

    @GetMapping("/disukai/history")
    public List<Resep> getHistory(Integer id){
        List<Resep> disukais = mDisukaiService.getHistory(id);
        return disukais;
    }

    @PostMapping("/disukai")
    public Object saveDisukai(HttpServletResponse response, @RequestBody Disukai userParam){
        Disukai liked = new Disukai(userParam.getId(),  userParam.getId_resep(), userParam.getId_user(), tgl);
        boolean isSuccess = mDisukaiService.saveDisukai(liked);

        if(isSuccess){
            return new Result(200, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }

    @DeleteMapping("/disukai")
    public Object deleteDisukai(HttpServletResponse response, @RequestParam("id") Integer id){
        boolean isSuccess = mDisukaiService.deleteDisukai(id);

        if(isSuccess){
            return new Result(200,"Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }
}

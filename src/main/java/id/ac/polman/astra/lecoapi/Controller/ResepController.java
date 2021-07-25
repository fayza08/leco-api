package id.ac.polman.astra.lecoapi.Controller;

import id.ac.polman.astra.lecoapi.service.ResepService;
import id.ac.polman.astra.lecoapi.vo.Resep;
import id.ac.polman.astra.lecoapi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ResepController {
    @Autowired
    ResepService mResepService;

//    @GetMapping("/resep")
//    public Resep getResep(@RequestParam("id") Integer id){
//        Resep resep = mResepService.getResepId(id);
//        return resep;
//    }

    @GetMapping("/resep")
    public Resep getResep(@RequestParam("id") Integer id){
        Resep resep = mResepService.getResepId(id);
        return resep;
    }

    @GetMapping("/resep/user")
    public List<Resep> getResepUser(@RequestParam("id") Integer id){
        List<Resep> resep = mResepService.getResepIdUser(id);
        return resep;
    }

    @GetMapping("/reseps")
    public List<Resep> getReseps(){
        List<Resep> resepList = mResepService.getReseps();
        return resepList;
    }

    @PostMapping("/resep")
    public Object saveResep(HttpServletResponse response, @RequestBody Resep userParam){
        Resep resep = new Resep(0, userParam.getId_user(), userParam.getNama(), userParam.getAlat_bahan(),
                userParam.getTahap(), userParam.getNilai(), userParam.getKeterangan(), userParam.getFoto(),0);
        boolean isSuccess = mResepService.saveResep(resep);

        if(isSuccess){
            return new Result(200, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }

    @PutMapping("/resep")
    public Object modifyResep(HttpServletResponse response, @RequestBody Resep userParam){
        Resep resep = new Resep(userParam.getId(), userParam.getId_user(), userParam.getNama(), userParam.getAlat_bahan(),
                userParam.getTahap(), userParam.getNilai(), userParam.getKeterangan(), userParam.getFoto(), userParam.getStatus());
        boolean isSuccess = mResepService.saveResep(resep);

        if(isSuccess){
            return new Result(200,"Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500,"Fail");
        }
    }

    @DeleteMapping("/resep")
    public Object deleteResep(HttpServletResponse response, @RequestParam("id") Integer id){
        boolean isSuccess = mResepService.deleteResep(id);

        if(isSuccess){
            return new Result(200,"Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(500, "Fail");
        }
    }
}

package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sn.douanes.gestionstockpostgres.entities.MarqueArme;
import sn.douanes.gestionstockpostgres.services.MarqueArmeService;


@RestController
public class MarqueArmeController {

    @Autowired
    MarqueArmeService marqueArmeService;

    @GetMapping("/MarqueArmes")
    @ResponseBody
    public List<MarqueArme> getAllMarqueArmes() {
        return marqueArmeService.getAllMarqueArmes();
    }

    @PostMapping("/AjouterMarqueArme")
    @ResponseBody
    public MarqueArme AjouterMarqueArme(@RequestBody MarqueArme m) {
        return marqueArmeService.saveMarqueArme(m);
    }

    @PutMapping("/ModifierMarqueArme")
    @ResponseBody
    public MarqueArme ModifierMarqueArme(@RequestBody MarqueArme m) {

        return marqueArmeService.updateMarqueArme(m);
    }

    @DeleteMapping("SupprimerMarqueArme/{id}")
    public void SupprimerMarqueArme(@PathVariable("id") String  code_marque_arme  ) {marqueArmeService.deleteMarqueArmeById( code_marque_arme  );}

}

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
import sn.douanes.gestionstockpostgres.entities.Armes;
import sn.douanes.gestionstockpostgres.services.ArmesService;


@RestController
public class ArmesController {

    @Autowired
    ArmesService armesService;

    @GetMapping("/Armes")
    @ResponseBody
    public List<Armes> getAllArmes() {
        return armesService.getAllArmes();
    }

    @PostMapping("/AjouterArmes")
    @ResponseBody
    public Armes AjouterArmes(@RequestBody Armes a) {
        return armesService.saveArmes(a);
    }

    @PutMapping("/ModifierArmes")
    @ResponseBody
    public Armes ModifierArmes(@RequestBody Armes a) {

        return armesService.updateArmes(a);
    }

    @DeleteMapping("SupprimerArmes/{id}")
    public void SupprimerArmes(@PathVariable("id") String numeroArme ) {armesService.deleteArmesById(numeroArme);}

}

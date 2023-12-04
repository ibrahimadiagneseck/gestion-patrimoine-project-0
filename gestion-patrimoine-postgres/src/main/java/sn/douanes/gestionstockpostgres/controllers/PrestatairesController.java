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
import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.services.PrestatairesService;


@RestController
public class PrestatairesController {

    @Autowired
    PrestatairesService prestatairesService;

    @GetMapping("/Prestataires")
    @ResponseBody
    public List<Prestataires> getAllPrestataires() {
        return prestatairesService.getAllPrestataires();
    }

    @PostMapping("/AjouterPrestataires")
    @ResponseBody
    public Prestataires AjouterPrestataires(@RequestBody Prestataires p) {
        return prestatairesService.savePrestataires(p);
    }

    @PutMapping("/ModifierPrestataires")
    @ResponseBody
    public Prestataires ModifierPrestataires(@RequestBody Prestataires p) {

        return prestatairesService.updatePrestataires(p);
    }

    @DeleteMapping("SupprimerPrestataires/{id}")
    public void SupprimerPrestataires(@PathVariable("id") String ninea) {prestatairesService.deletePrestatairesById(ninea);}

}

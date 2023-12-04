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
import sn.douanes.gestionstockpostgres.entities.UniteDouaniere;
import sn.douanes.gestionstockpostgres.services.UniteDouaniereService;


@RestController
public class UniteDouaniereController {

    @Autowired
    UniteDouaniereService uniteDouaniereService;

    @GetMapping("/UniteDouanieres")
    @ResponseBody
    public List<UniteDouaniere> getAllUniteDouanieres() {
        return uniteDouaniereService.getAllUniteDouanieres();
    }

    @PostMapping("/AjouterUniteDouaniere")
    @ResponseBody
    public UniteDouaniere AjouterUniteDouaniere(@RequestBody UniteDouaniere u) {
        return uniteDouaniereService.saveUniteDouaniere(u);
    }

    @PutMapping("/ModifierUniteDouaniere")
    @ResponseBody
    public UniteDouaniere ModifierUniteDouaniere(@RequestBody UniteDouaniere u) {

        return uniteDouaniereService.updateUniteDouaniere(u);
    }

    @DeleteMapping("SupprimerUniteDouaniere/{id}")
    public void SupprimerUniteDouaniere(@PathVariable("id") String codeUniteDouaniere) {uniteDouaniereService.deleteUniteDouaniereById(codeUniteDouaniere);}

}

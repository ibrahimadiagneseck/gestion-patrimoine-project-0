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
import sn.douanes.gestionstockpostgres.entities.TypeUniteDouaniere;
import sn.douanes.gestionstockpostgres.services.TypeUniteDouaniereService;


@RestController
public class TypeUniteDouaniereController {

    @Autowired
    TypeUniteDouaniereService typeUniteDouaniereService;

    @GetMapping("/TypeUniteDouanieres")
    @ResponseBody
    public List<TypeUniteDouaniere> getAllTypeUniteDouanieres() {
        return typeUniteDouaniereService.getAllTypeUniteDouanieres();
    }

    @PostMapping("/AjouterTypeUniteDouaniere")
    @ResponseBody
    public TypeUniteDouaniere AjouterTypeUniteDouaniere(@RequestBody TypeUniteDouaniere t) {
        return typeUniteDouaniereService.saveTypeUniteDouaniere(t);
    }

    @PutMapping("/ModifierTypeUniteDouaniere")
    @ResponseBody
    public TypeUniteDouaniere ModifierTypeUniteDouaniere(@RequestBody TypeUniteDouaniere t) {

        return typeUniteDouaniereService.updateTypeUniteDouaniere(t);
    }

    @DeleteMapping("SupprimerTypeUniteDouaniere/{id}")
    public void SupprimerTypeUniteDouaniere(@PathVariable("id") String codeTypeUniteDouaniere) {typeUniteDouaniereService.deleteTypeUniteDouaniereById(codeTypeUniteDouaniere);}

}

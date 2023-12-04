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
import sn.douanes.gestionstockpostgres.entities.TypeArme;
import sn.douanes.gestionstockpostgres.services.TypeArmeService;


@RestController
public class TypeArmeController {

    @Autowired
    TypeArmeService typeArmeService;

    @GetMapping("/TypeArmes")
    @ResponseBody
    public List<TypeArme> getAllTypeArmes() {
        return typeArmeService.getAllTypeArmes();
    }

    @PostMapping("/AjouterTypeArme")
    @ResponseBody
    public TypeArme AjouterTypeArme(@RequestBody TypeArme t) {
        return typeArmeService.saveTypeArme(t);
    }

    @PutMapping("/ModifierTypeArme")
    @ResponseBody
    public TypeArme ModifierTypeArme(@RequestBody TypeArme t) {

        return typeArmeService.updateTypeArme(t);
    }

    @DeleteMapping("SupprimerTypeArme/{id}")
    public void SupprimerTypeArme(@PathVariable("id") String  code_type_arme ) {typeArmeService.deleteTypeArmeById( code_type_arme );}

}

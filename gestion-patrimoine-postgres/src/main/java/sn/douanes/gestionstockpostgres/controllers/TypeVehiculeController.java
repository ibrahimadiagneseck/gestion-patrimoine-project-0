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
import sn.douanes.gestionstockpostgres.entities.TypeVehicule;
import sn.douanes.gestionstockpostgres.services.TypeVehiculeService;


@RestController
public class TypeVehiculeController {

    @Autowired
    TypeVehiculeService typeVehiculeService;

    @GetMapping("/TypeVehicules")
    @ResponseBody
    public List<TypeVehicule> getAllTypeVehicules() {
        return typeVehiculeService.getAllTypeVehicules();
    }

    @PostMapping("/AjouterTypeVehicule")
    @ResponseBody
    public TypeVehicule AjouterTypeVehicule(@RequestBody TypeVehicule t) {
        return typeVehiculeService.saveTypeVehicule(t);
    }

    @PutMapping("/ModifierTypeVehicule")
    @ResponseBody
    public TypeVehicule ModifierTypeVehicule(@RequestBody TypeVehicule t) {
        return typeVehiculeService.updateTypeVehicule(t);
    }

    @DeleteMapping("SupprimerTypeVehicule/{id}")
    public void SupprimerTypeVehicule(@PathVariable("id") String codeTypeVehicule) {
        typeVehiculeService.deleteTypeVehiculeById(codeTypeVehicule);
    }

}

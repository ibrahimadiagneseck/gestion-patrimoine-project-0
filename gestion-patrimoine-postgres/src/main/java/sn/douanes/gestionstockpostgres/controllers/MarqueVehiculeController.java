package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.MarqueVehicule;
import sn.douanes.gestionstockpostgres.services.MarqueVehiculeService;

import java.util.List;


@RestController
public class MarqueVehiculeController {

    @Autowired
    MarqueVehiculeService marqueVehiculeService;

    @GetMapping("/MarqueVehicules")
    @ResponseBody
    public List<MarqueVehicule> getAllMarqueVehicules() {
        return marqueVehiculeService.getAllMarqueVehicules();
    }

    @PostMapping("/AjouterMarqueVehicule")
    @ResponseBody
    public MarqueVehicule AjouterMarqueVehicule(@RequestBody MarqueVehicule t) {
        return marqueVehiculeService.saveMarqueVehicule(t);
    }

    @PutMapping("/ModifierMarqueVehicule")
    @ResponseBody
    public MarqueVehicule ModifierMarqueVehicule(@RequestBody MarqueVehicule t) {
        return marqueVehiculeService.updateMarqueVehicule(t);
    }

    @DeleteMapping("SupprimerMarqueVehicule/{id}")
    public void SupprimerMarqueVehicule(@PathVariable("id") String codeMarque) {
        marqueVehiculeService.deleteMarqueVehiculeById(codeMarque);
    }

}

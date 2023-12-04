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
import sn.douanes.gestionstockpostgres.entities.Carburant;
import sn.douanes.gestionstockpostgres.services.CarburantService;


@RestController
public class CarburantController {

    @Autowired
    CarburantService carburantService;

    @GetMapping("/Carburants")
    @ResponseBody
    public List<Carburant> getAllCarburants() {
        return carburantService.getAllCarburants();
    }

    @PostMapping("/AjouterCarburant")
    @ResponseBody
    public Carburant AjouterCarburant(@RequestBody Carburant c) {
        return carburantService.saveCarburant(c);
    }

    @PutMapping("/ModifierCarburant")
    @ResponseBody
    public Carburant ModifierCarburant(@RequestBody Carburant c) {

        return carburantService.updateCarburant(c);
    }

    @DeleteMapping("SupprimerCarburant/{id}")
    public void SupprimerCarburant(@PathVariable("id") String numeroCarte ) {carburantService.deleteCarburantById(numeroCarte);}

}

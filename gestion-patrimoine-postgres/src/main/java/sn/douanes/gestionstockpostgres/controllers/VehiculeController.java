package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.UniteHierarchique;
import sn.douanes.gestionstockpostgres.entities.Vehicule;
import sn.douanes.gestionstockpostgres.services.VehiculeService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;



@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class VehiculeController {

    @Autowired
    VehiculeService vehiculeService;

    @GetMapping("/Vehicules")
    public ResponseEntity<List<Vehicule>> listeVehicules() {
        List<Vehicule> vehicules = vehiculeService.getAllVehicules();
        return new ResponseEntity<>(vehicules, OK);
    }


//    @PostMapping("/AjouterVehicule")
//    @ResponseBody
//    public Vehicule AjouterVehicule(@RequestBody Vehicule v) {
//        return vehiculeService.saveVehicule(v);
//    }

    @PostMapping("/AjouterVehicule")
    public ResponseEntity<Vehicule> AjouterVehicule(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("role") String role,
            @RequestParam("isActive") String isActive
    ) {

        Vehicule vehicule = vehiculeService.ajouterVehicule(firstName, lastName, username,email, role, Boolean.parseBoolean(isNonLocked), Boolean.parseBoolean(isActive), profileImage);
        return new ResponseEntity<>(vehicule, OK);
    }


    @PutMapping("/ModifierVehicule")
    @ResponseBody
    public Vehicule ModifierVehicule(@RequestBody Vehicule v) {
        
        return vehiculeService.updateVehicule(v);
    }


    @DeleteMapping("SupprimerVehicule/{id}")
    public void SupprimerVehicule(@PathVariable("id") String numeroSerie) {
        vehiculeService.deleteVehiculeById(numeroSerie);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus
        );
    }
}

package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
import sn.douanes.gestionstockpostgres.services.VehiculeService;

import java.util.Date;
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


    @PostMapping("/AjouterVehicule")
    @ResponseBody
    public Vehicule AjouterVehicule(@RequestBody Vehicule v) {
        return vehiculeService.saveVehicule(v);
    }

    @PostMapping("/AjouterRequestParamVehicule")
    public ResponseEntity<Vehicule> ajouterVehicule(
            @RequestParam("numeroSerie") String numeroSerie,
            @RequestParam("numeroImmatriculation") String numeroImmatriculation,
            @RequestParam("genre") String genre,
            @RequestParam("modele") String modele,
            @RequestParam("etatVehicule") String etatVehicule,
            @RequestParam("typeEnergie") String typeEnergie,
            @RequestParam("numeroCarteGrise") String numeroCarteGrise,
            @RequestParam("dateMiseEnCirculation") Date dateMiseEnCirculation,
            @RequestParam("codePays") Pays codePays,
            @RequestParam("codeTypeVehicule") TypeVehicule codeTypeVehicule,
            @RequestParam("codeMarque") MarqueVehicule codeMarque,
            @RequestParam("codeUniteDouaniere") UniteDouaniere codeUniteDouaniere,
            @RequestParam("identifiantBE") ArticleBonEntree identifiantBE
    ) {
        Vehicule vehicule = vehiculeService.ajouterVehicule(numeroSerie, numeroImmatriculation, genre, modele, etatVehicule, typeEnergie, numeroCarteGrise, dateMiseEnCirculation, codePays, codeTypeVehicule, codeMarque, codeUniteDouaniere, identifiantBE);
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

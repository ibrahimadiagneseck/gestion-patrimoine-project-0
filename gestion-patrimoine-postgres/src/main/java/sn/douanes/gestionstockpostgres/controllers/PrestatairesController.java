package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Pays;
import sn.douanes.gestionstockpostgres.entities.Prestataires;
import sn.douanes.gestionstockpostgres.entities.SecteurActivite;
import sn.douanes.gestionstockpostgres.services.PrestatairesService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class PrestatairesController {

    @Autowired
    PrestatairesService prestatairesService;


    @GetMapping("/Prestataires")
    public ResponseEntity<List<Prestataires>> getAllPrestataires() {
        List<Prestataires> prestataires = prestatairesService.getAllPrestataires();
        return new ResponseEntity<>(prestataires, OK);
    }

    @PostMapping("/AjouterPrestataires")
    @ResponseBody
    public Prestataires AjouterPrestataires(@RequestBody Prestataires prestataires) {
        return prestatairesService.savePrestataires(prestataires);
    }

    @PostMapping("/AjouterRequestParamPrestataires")
    public ResponseEntity<Prestataires> ajouterPrestataires (
            @RequestParam("ninea") String ninea,
            @RequestParam("raisonSociale") String raisonSociale,
            @RequestParam("numeroTelephone") Integer numeroTelephone,
            @RequestParam("adresseEmail") String adresseEmail,
            @RequestParam("adresse") String adresse
    ) {
        Prestataires prestataires = prestatairesService.ajouterPrestataires(ninea, raisonSociale, numeroTelephone, adresseEmail, adresse);
        return new ResponseEntity<>(prestataires, OK);
    }


    @PutMapping("/ModifierPrestataires")
    @ResponseBody
    public Prestataires ModifierPrestataires(@RequestBody Prestataires p) {

        return prestatairesService.updatePrestataires(p);
    }

    @DeleteMapping("SupprimerPrestatairesById/{id}")
    public void SupprimerPrestatairesById(@PathVariable("id") String ninea) {
        prestatairesService.deletePrestatairesById(ninea);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}

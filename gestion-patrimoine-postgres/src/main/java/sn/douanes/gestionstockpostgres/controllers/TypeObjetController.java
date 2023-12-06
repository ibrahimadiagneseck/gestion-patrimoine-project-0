package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.TypeMateriel;
import sn.douanes.gestionstockpostgres.entities.TypeObjet;
import sn.douanes.gestionstockpostgres.services.TypeObjetService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class TypeObjetController {

    @Autowired
    TypeObjetService typeObjetService;


    @GetMapping("/TypeObjets")
    public ResponseEntity<List<TypeObjet>> getAllTypeObjets() {
        List<TypeObjet> typeObjet = typeObjetService.getAllTypeObjets();
        return new ResponseEntity<>(typeObjet, OK);
    }

    @PostMapping("/AjouterTypeObjet")
    @ResponseBody
    public TypeObjet AjouterTypeObjet(@RequestBody TypeObjet t) {
        return typeObjetService.saveTypeObjet(t);
    }

    @PutMapping("/ModifierTypeObjet")
    @ResponseBody
    public TypeObjet ModifierTypeObjet(@RequestBody TypeObjet t) {

        return typeObjetService.updateTypeObjet(t);
    }

    @DeleteMapping("SupprimerTypeObjet/{id}")
    public void SupprimerTypeObjet(@PathVariable("id") String codeTypeObjet) {typeObjetService.deleteTypeObjetById(codeTypeObjet);}


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}

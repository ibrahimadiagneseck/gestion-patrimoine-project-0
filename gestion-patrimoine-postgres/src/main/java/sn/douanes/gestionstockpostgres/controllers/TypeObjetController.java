package sn.douanes.gestionstockpostgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.TypeObjet;
import sn.douanes.gestionstockpostgres.services.TypeObjetService;

import java.util.List;


@RestController
public class TypeObjetController {

    @Autowired
    TypeObjetService typeObjetService;

    @GetMapping("/TypeObjets")
    @ResponseBody
    public List<TypeObjet> getAllTypeObjets() {
        return typeObjetService.getAllTypeObjets();
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

}

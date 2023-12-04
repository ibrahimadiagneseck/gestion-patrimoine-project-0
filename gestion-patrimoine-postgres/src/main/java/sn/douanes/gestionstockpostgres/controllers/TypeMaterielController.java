package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.TypeMateriel;
import sn.douanes.gestionstockpostgres.services.TypeMaterielService;


@RestController

public class TypeMaterielController {

    @Autowired
    TypeMaterielService typeMaterielService;

    @GetMapping("/TypeMateriels")
    @ResponseBody
    public List<TypeMateriel> getAllTypeMateriels() {
        return typeMaterielService.getAllTypeMateriels();
    }

    @PostMapping("/AjouterTypeMateriel")
    @ResponseBody
    public TypeMateriel AjouterTypeMateriel(@RequestBody TypeMateriel t) {
        return typeMaterielService.saveTypeMateriel(t);
    }

    @PutMapping("/ModifierTypeMateriel")
    @ResponseBody
    public TypeMateriel ModifierTypeMateriel(@RequestBody TypeMateriel t) {

        return typeMaterielService.updateTypeMateriel(t);
    }

    @DeleteMapping("SupprimerTypeMateriel/{id}")
    public void SupprimerTypeMateriel(@PathVariable("id") String  code_type_materiel ) {typeMaterielService.deleteTypeMaterielById( code_type_materiel );}

}

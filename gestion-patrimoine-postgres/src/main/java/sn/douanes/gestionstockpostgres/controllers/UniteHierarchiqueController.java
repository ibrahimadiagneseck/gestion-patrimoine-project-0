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
import sn.douanes.gestionstockpostgres.entities.UniteHierarchique;
import sn.douanes.gestionstockpostgres.services.UniteHierarchiqueService;


@RestController
public class UniteHierarchiqueController {

    @Autowired
    UniteHierarchiqueService uniteHierarchiqueService;

    @GetMapping("/UniteHierarchiques")
    @ResponseBody
    public List<UniteHierarchique> getAllUniteHierarchiques() {
        return uniteHierarchiqueService.getAllUniteHierarchiques();
    }

    @PostMapping("/AjouterUniteHierarchique")
    @ResponseBody
    public UniteHierarchique AjouterUniteHierarchique(@RequestBody UniteHierarchique u) {
        return uniteHierarchiqueService.saveUniteHierarchique(u);
    }

    @PutMapping("/ModifierUniteHierarchique")
    @ResponseBody
    public UniteHierarchique ModifierUniteHierarchique(@RequestBody UniteHierarchique u) {

        return uniteHierarchiqueService.updateUniteHierarchique(u);
    }

    @DeleteMapping("SupprimerUniteHierarchique/{id}")
    public void SupprimerUniteHierarchique(@PathVariable("id") String    code_unite_hierarchique ) {uniteHierarchiqueService.deleteUniteHierarchiqueById(  code_unite_hierarchique);}

}

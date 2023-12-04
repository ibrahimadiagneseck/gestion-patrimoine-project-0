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
import sn.douanes.gestionstockpostgres.entities.Materiels;
import sn.douanes.gestionstockpostgres.services.MaterielsService;


@RestController
public class MaterielsController {

    @Autowired
    MaterielsService materielsService;

    @GetMapping("/Materiels")
    @ResponseBody
    public List<Materiels> getAllMateriels() {
        return materielsService.getAllMateriels();
    }

    @PostMapping("/AjouterMateriels")
    @ResponseBody
    public Materiels AjouterMateriels(@RequestBody Materiels m) {
        return materielsService.saveMateriels(m);
    }

    @PutMapping("/ModifierMateriels")
    @ResponseBody
    public Materiels ModifierMateriels(@RequestBody Materiels m) {

        return materielsService.updateMateriels(m);
    }

    @DeleteMapping("SupprimerMateriels/{id}")
    public void SupprimerMateriels(@PathVariable("id") String  code_materiel  ) {materielsService.deleteMaterielsById( code_materiel );}

}

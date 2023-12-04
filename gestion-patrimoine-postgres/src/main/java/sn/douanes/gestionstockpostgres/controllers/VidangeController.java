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
import sn.douanes.gestionstockpostgres.entities.Vidange;
import sn.douanes.gestionstockpostgres.services.VidangeService;


@RestController
public class VidangeController {

    @Autowired
    VidangeService vidangeService;

    @GetMapping("/Vidanges")
    @ResponseBody
    public List<Vidange> getAllVidanges() {
        return vidangeService.getAllVidanges();
    }

    @PostMapping("/AjouterVidange")
    @ResponseBody
    public Vidange AjouterVidange(@RequestBody Vidange v) {
        return vidangeService.saveVidange(v);
    }

    @PutMapping("/ModifierVidange")
    @ResponseBody
    public Vidange ModifierVidange(@RequestBody Vidange v) {

        return vidangeService.updateVidange(v);
    }

    @DeleteMapping("SupprimerVidange/{id}")
    public void SupprimerVidange(@PathVariable("id") String vidange) {vidangeService.deleteVidangeById(vidange);}

}

package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.BordereauLivraison;
import sn.douanes.gestionstockpostgres.entities.Sections;
import sn.douanes.gestionstockpostgres.services.BordereauLivraisonService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class BordereauLivraisonController {

    @Autowired
    BordereauLivraisonService bordereauLivraisonService;

    @GetMapping("/BordereauLivraisons")
    public ResponseEntity<List<BordereauLivraison>> getAllBordereauLivraisons() {
        List<BordereauLivraison> bordereauLivraisons = bordereauLivraisonService.getAllBordereauLivraisons();
        return new ResponseEntity<>(bordereauLivraisons, OK);
    }

    @PostMapping("/AjouterBordereauLivraison")
    @ResponseBody
    public BordereauLivraison AjouterBordereauLivraison(@RequestBody BordereauLivraison b) {
        return bordereauLivraisonService.saveBordereauLivraison(b);
    }

    @PutMapping("/ModifierBordereauLivraison")
    @ResponseBody
    public BordereauLivraison ModifierBordereauLivraison(@RequestBody BordereauLivraison b) {

        return bordereauLivraisonService.updateBordereauLivraison(b);
    }

    @DeleteMapping("SupprimerBordereauLivraison/{id}")
    public void SupprimerBordereauLivraison(@PathVariable("id") String identifiantBL) {bordereauLivraisonService.deleteBordereauLivraisonById(identifiantBL);}

}

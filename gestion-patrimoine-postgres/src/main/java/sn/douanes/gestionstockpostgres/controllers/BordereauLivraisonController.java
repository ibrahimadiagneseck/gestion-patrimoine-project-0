package sn.douanes.gestionstockpostgres.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.*;
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
    public BordereauLivraison AjouterBordereauLivraison(@RequestBody BordereauLivraison bordereauLivraison) {
        return bordereauLivraisonService.saveBordereauLivraison(bordereauLivraison);
    }

    @PostMapping("/AjouterRequestParamBordereauLivraison")
    public ResponseEntity<BordereauLivraison> ajouterBordereauLivraison (
            @RequestParam("numeroBE") String numeroBL,
            @RequestParam("numeroBE") String descriptionBL,
            @RequestParam("numeroBE") String lieuDeLivraison,
            @RequestParam("numeroBE") Date dateBL,
            @RequestParam("numeroBE") String conformiteBL,
            @RequestParam("numeroBE") String nomLivreur,
            @RequestParam("numeroBE") Sections codeSection,
            @RequestParam("numeroBE") Prestataires ninea,
            @RequestParam("numeroBE") Agent matriculeAgent
    ) {
        BordereauLivraison bordereauLivraison = bordereauLivraisonService.ajouterBordereauLivraison(numeroBL, descriptionBL, lieuDeLivraison, dateBL, conformiteBL, nomLivreur, codeSection, ninea, matriculeAgent);
        return new ResponseEntity<>(bordereauLivraison, OK);
    }

    @PutMapping("/ModifierBordereauLivraison")
    @ResponseBody
    public BordereauLivraison ModifierBordereauLivraison(@RequestBody BordereauLivraison b) {

        return bordereauLivraisonService.updateBordereauLivraison(b);
    }

    @DeleteMapping("SupprimerBordereauLivraison/{id}")
    public void SupprimerBordereauLivraison(@PathVariable("id") String identifiantBL) {bordereauLivraisonService.deleteBordereauLivraisonById(identifiantBL);}


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}

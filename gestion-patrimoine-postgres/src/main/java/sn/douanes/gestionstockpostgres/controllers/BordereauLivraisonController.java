package sn.douanes.gestionstockpostgres.controllers;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
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
            @RequestParam("numeroBL") String numeroBL,
            @RequestParam("descriptionBL") String descriptionBL,
            @RequestParam("lieuDeLivraison") String lieuDeLivraison,
            @RequestParam("dateBL") String dateBL,
            @RequestParam("conformiteBL") String conformiteBL,
            @RequestParam("nomLivreur") String nomLivreur,
            @RequestParam(value = "codeSection") Sections codeSection,
            @RequestParam(value = "ninea") Prestataires ninea,
            @RequestParam(value = "matriculeAgent") Agent matriculeAgent
    ) {
        // @RequestParam(value = "codeSection", required = false) Sections codeSection,
        // dateBL = java.sql.Date.valueOf("2017-11-15");
        // dateBL = new java.sql.Date(dateBL.getTime());

        System.out.println(codeSection.toString());
        System.out.println(ninea.toString());
        System.out.println(matriculeAgent.toString());


        BordereauLivraison bordereauLivraison = bordereauLivraisonService.ajouterBordereauLivraison(numeroBL, descriptionBL, lieuDeLivraison, Date.valueOf(dateBL), conformiteBL, nomLivreur, new Sections(), new Prestataires(), new Agent());
        return new ResponseEntity<>(bordereauLivraison, OK);
    }

    @PutMapping("/ModifierBordereauLivraison")
    @ResponseBody
    public BordereauLivraison ModifierBordereauLivraison(@RequestBody BordereauLivraison b) {
        return bordereauLivraisonService.updateBordereauLivraison(b);
    }

    @DeleteMapping("SupprimerBordereauLivraisonById/{id}")
    public void SupprimerBordereauLivraisonById(@PathVariable("id") String identifiantBL) {
        bordereauLivraisonService.deleteBordereauLivraisonById(identifiantBL);
    }


    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus
        );
    }


}

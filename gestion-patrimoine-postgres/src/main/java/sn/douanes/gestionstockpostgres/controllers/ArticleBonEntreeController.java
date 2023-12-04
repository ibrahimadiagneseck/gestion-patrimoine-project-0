package sn.douanes.gestionstockpostgres.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.douanes.gestionstockpostgres.entities.ArticleBonEntree;
import sn.douanes.gestionstockpostgres.entities.HttpResponse;
import sn.douanes.gestionstockpostgres.entities.Vehicule;
import sn.douanes.gestionstockpostgres.services.ArticleBonEntreeService;

import static org.springframework.http.HttpStatus.OK;


@RestController
//@RequestMapping(path = { "/", "/user"})
@RequestMapping( "/")
@CrossOrigin("http://localhost:4200")
public class ArticleBonEntreeController {

    @Autowired
    ArticleBonEntreeService articleBonEntreeService;


    @GetMapping("/ArticleBonEntrees")
    public ResponseEntity<List<ArticleBonEntree>> getAllArticleBonEntrees() {
        List<ArticleBonEntree> articleBonEntree = articleBonEntreeService.getAllArticleBonEntrees();
        return new ResponseEntity<>(articleBonEntree, OK);
    }

    @PostMapping("/AjouterArticleBonEntree")
    @ResponseBody
    public ArticleBonEntree AjouterArticleBonEntree(@RequestBody ArticleBonEntree a) {
        return articleBonEntreeService.saveArticleBonEntree(a);
    }

    @PutMapping("/ModifierArticleBonEntree")
    @ResponseBody
    public ArticleBonEntree ModifierArticleBonEntree(@RequestBody ArticleBonEntree a) {

        return articleBonEntreeService.updateArticleBonEntree(a);
    }

    @DeleteMapping("SupprimerArticleBonEntree/{id}")
    public void SupprimerArticleBonEntree(@PathVariable("id") String identifiantBECodeArticleBonEntree) {articleBonEntreeService.deleteArticleBonEntreeById(identifiantBECodeArticleBonEntree);}

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
                httpStatus
        );
    }

}

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
import sn.douanes.gestionstockpostgres.entities.ArticleBonSortie;
import sn.douanes.gestionstockpostgres.services.ArticleBonSortieService;


@RestController
public class ArticleBonSortieController {

    @Autowired
    ArticleBonSortieService articleBonSortieService;

    @GetMapping("/ArticleBonSorties")
    @ResponseBody
    public List<ArticleBonSortie> getAllArticleBonSorties() {
        return articleBonSortieService.getAllArticleBonSorties();
    }

    @PostMapping("/AjouterArticleBonSortie")
    @ResponseBody
    public ArticleBonSortie AjouterArticleBonSortie(@RequestBody ArticleBonSortie a) {
        return articleBonSortieService.saveArticleBonSortie(a);
    }

    @PutMapping("/ModifierArticleBonSortie")
    @ResponseBody
    public ArticleBonSortie ModifierArticleBonSortie(@RequestBody ArticleBonSortie a) {

        return articleBonSortieService.updateArticleBonSortie(a);
    }

    @DeleteMapping("SupprimerArticleBonSortie/{id}")
    public void SupprimerArticleBonSortie(@PathVariable("id") String  codeArticleBonSortie  ) {articleBonSortieService.deleteArticleBonSortieById(codeArticleBonSortie);}

}

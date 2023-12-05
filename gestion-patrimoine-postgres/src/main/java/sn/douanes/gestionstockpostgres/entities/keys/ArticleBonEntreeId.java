package sn.douanes.gestionstockpostgres.entities.keys;

import sn.douanes.gestionstockpostgres.entities.BonEntree;

import java.io.Serializable;


public class ArticleBonEntreeId implements Serializable {

    private BonEntree identifiantBE;

    private Integer codeArticleBonEntree;

    public ArticleBonEntreeId() {
    }

    public ArticleBonEntreeId(BonEntree identifiantBE, Integer codeArticleBonEntree) {
        this.identifiantBE = identifiantBE;
        this.codeArticleBonEntree = codeArticleBonEntree;
    }
}
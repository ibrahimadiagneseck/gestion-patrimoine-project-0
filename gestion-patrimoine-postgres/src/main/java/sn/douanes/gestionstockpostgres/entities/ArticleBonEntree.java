package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.douanes.gestionstockpostgres.entities.keys.ArticleBonEntreeId;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@Entity
@IdClass(ArticleBonEntreeId.class)
@Table(name = "article_bon_entree")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleBonEntree {


    @Id
    @ManyToOne
    @JoinColumn(name = "identifiant_b_e")
    private BonEntree identifiantBE;

    @Id
    @Column(name = "code_article_bon_entree")
    private Integer codeArticleBonEntree;

    @Column(name = "libelle_article_bon_entree")
    private String libelleArticleBonEntree;

    @Column(name = "quantite_entree")
    private Integer quantiteEntree;

    @Column(name = "date_enregistrement")
    private SimpleDateFormat dateEnregistrement;

    @ManyToOne
    @JoinColumn(name = "code_type_objet")
    private TypeObjet codeTypeObjet;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule_agent"),
            @JoinColumn(name = "code_corps_agent", referencedColumnName = "code_corps_agent")
    })
    private Agent matriculeAgent;


}
package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name = "bon_entree")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BonEntree {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "identifiant_b_e", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "identifiant_b_e", length = 25)
    private String identifiantBE;

    @Column(name = "numero_b_e", length = 100)
    private String numeroBE;

    @Column(name = "libelle_bon_entree")
    private String libelleBonEntree;

    @Column(name = "date_bon_entree")
    private Date dateBonEntree;

    @Column(name = "observation_bon_entree")
    private String observationBonEntree;


    @Column(name = "date_enregistrement")
    private SimpleDateFormat dateEnregistrement;


    @ManyToOne
    @JoinColumn(name = "identifiant_b_l")
    private BordereauLivraison identifiantBL;

//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule_agent"),
//            @JoinColumn(name = "code_corps_agent", referencedColumnName = "code_corps_agent")
//    })
//    private Agent matriculeAgent;


//    @ManyToOne
//    @JoinColumn(name = "code_section")
//    private Sections codeSection;

}
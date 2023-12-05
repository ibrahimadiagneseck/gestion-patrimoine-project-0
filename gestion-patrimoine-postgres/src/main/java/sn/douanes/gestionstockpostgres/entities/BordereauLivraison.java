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
@Table(name = "bordereau_livraison")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BordereauLivraison {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "identifiant_b_l", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "identifiant_b_l", length = 25)
    private String identifiantBL;

    @Column(name = "numero_b_l", length = 100)
    private String numeroBL;

    @Column(name = "description_b_l", length = 512)
    private String descriptionBL;

    @Column(name = "lieu_de_livraison")
    private String lieuDeLivraison;

    @Column(name = "date_b_l")
    private Date dateBL;

    @Column(name = "conformite_b_l", length = 3)
    private String conformiteBL;


    @Column(name = "nom_livreur", length = 512)
    private String nomLivreur;


    @ManyToOne
    @JoinColumn(name = "code_section")
    private Sections codeSection;

    @ManyToOne
    @JoinColumn(name = "ninea")
    private Prestataires ninea;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule_agent"),
            @JoinColumn(name = "code_corps_agent", referencedColumnName = "code_corps_agent")
    })
    private Agent matriculeAgent;



    @Column(name = "date_enregistrement")
    private SimpleDateFormat dateEnregistrement;



}
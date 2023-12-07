package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Table(name = "prestataires")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prestataires {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "ninea", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "ninea", length = 20)
    private String ninea;

    @Column(name = "raison_sociale", length = 512)
    private String raisonSociale;

    @Column(name = "numero_telephone")
    private Integer numeroTelephone;

    @Column(name = "adresse_email", length = 100)
    private String adresseEmail;

    @Column(name = "adresse", length = 512)
    private String adresse;


    @ManyToMany
    @JoinTable(
            name = "prestataires_secteur",
            joinColumns = @JoinColumn(name = "ninea"),
            inverseJoinColumns = @JoinColumn(name = "code_secteur_activite")
    )
    private Set<SecteurActivite> secteursActivite;



//    // Création d'un prestataire
//    Prestataires prestataire = new Prestataires();
//    prestataire.setNinea("123456789");
//    prestataire.setRaisonSociale("Nom de l'entreprise");
//    prestataire.setNumeroTelephone("0123456789");
//    prestataire.setAdresseEmail("exemple@email.com");
//    prestataire.setAdresse("Adresse de l'entreprise");
//
//    // Création des secteurs d'activité
//    SecteurActivite secteur1 = new SecteurActivite();
//    secteur1.setCodeSecteurActivite("Code1");
//    secteur1.setLibelleSecteurActivite("Libellé 1");
//
//    SecteurActivite secteur2 = new SecteurActivite();
//    secteur2.setCodeSecteurActivite("Code2");
//    secteur2.setLibelleSecteurActivite("Libellé 2");
//
//    // Ajout des secteurs d'activité au prestataire
//    Set<SecteurActivite> secteursActivite = new HashSet<>();
//    secteursActivite.add(secteur1);
//    secteursActivite.add(secteur2);
//
//    prestataire.setSecteursActivite(secteursActivite);



}

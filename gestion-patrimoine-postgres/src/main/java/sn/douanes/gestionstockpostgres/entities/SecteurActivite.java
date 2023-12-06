package sn.douanes.gestionstockpostgres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "secteur-activite")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecteurActivite {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "code_section", nullable = false, updatable = false)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "code_secteur_activite", length = 10)
    private String codeSecteurActivite;

    @Column(name = "libelle_secteur_activite")
    private String libelleSecteurActivite;

    @ManyToMany(mappedBy = "secteursActivite")
    private Set<Prestataires> prestataires;


}

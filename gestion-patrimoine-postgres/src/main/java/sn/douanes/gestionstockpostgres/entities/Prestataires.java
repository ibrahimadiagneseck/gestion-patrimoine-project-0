package sn.douanes.gestionstockpostgres.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    @Column(name = "adresse", length = 512)
    private String adresse;


}

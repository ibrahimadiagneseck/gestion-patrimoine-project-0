

public class Agent {

    @Id
    @Column(name = "matricule_agent", length = 7)
    private String matriculeAgent;

    @Column(name = "code_agent", unique = true, length = 5)
    private String codeAgent;

    @Column(name = "nom_agent", length = 100)
    private String nomAgent;

    @Column(name = "prenom_agent", length = 255)
    private String prenomAgent;

    @Column(name = "numero_telephone_agent")
    private Integer numeroTelephoneAgent;

    @ManyToOne
    @JoinColumn(name = "code_fonction_agent")
    private FonctionAgent fonctionAgent;

    @ManyToOne
    @JoinColumn(name = "code_unite_douaniere")
    private UniteDouaniere uniteDouaniere;

    @Id
    @ManyToOne
    @JoinColumn(name = "code_corps_agent")
    private CorpsAgent codeCorpsAgent;
}


public class FonctionAgent {

    @Id
    @Column(name = "code_fonction_agent", length = 10)
    private String codeFonctionAgent;

    @Column(name = "libelle_fonction_agent", length = 100)
    private String libelleFonctionAgent;
}


public class UniteDouaniere {

    @Id
    @Column(name = "code_unite_douaniere", length = 3)
    private String codeUniteDouaniere;

    @Column(name = "nom_unite_douaniere", length = 255)
    private String nomUniteDouaniere;

    @Column(name = "effectif_unite_douaniere")
    private Integer effectifUniteDouaniere;

    @Column(name = "nombre_arme")
    private Integer nombreArme;

    @Column(name = "nombre_automobile")
    private Integer nombreAutomobile;

    @Column(name = "nombre_materiel")
    private Integer nombreMateriel;

    @ManyToOne
    @JoinColumn(name = "code_type_unite_douaniere")
    private TypeUniteDouaniere codeTypeUniteDouaniere;
}


public class TypeUniteDouaniere {

    @Id
    @Column(name = "code_type_unite_douaniere", length = 5)
    private String codeTypeUniteDouaniere;

    @Column(name = "libelle_type_unite_douaniere", length = 100)
    private String libelleTypeUniteDouaniere;
}


public class CorpsAgent {

    @Id
    @Column(name = "code_corps_agent", length = 3)
    private String codeCorpsAgent;

    @Column(name = "libelle_corps_agent", length = 100)
    private String libelleCorpsAgent;
}


public class BordereauLivraison {

    @Id
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
    private Timestamp dateEnregistrement = new Timestamp(System.currentTimeMillis());
}


public class Prestataires {

    @Id
    @Column(name = "ninea", length = 20)
    private String ninea;

    @Column(name = "raison_sociale", length = 512)
    private String raisonSociale;

    @Column(name = "numero_telephone")
    private Integer numeroTelephone;

    @Column(name = "adresse", length = 512)
    private String adresse;
}


public class Sections {

    @Id
    @Column(name = "code_section", length = 3)
    private String codeSection;

    @Column(name = "libelle_section", length = 100)
    private String libelleSection;

    @ManyToOne
    @JoinColumn(name = "code_unite_douaniere")
    private UniteDouaniere codeUniteDouaniere;
}


public class BonEntree {

    @Id
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
    private Timestamp dateEnregistrement = new Timestamp(System.currentTimeMillis());

    @ManyToOne
    @JoinColumn(name = "identifiant_b_l")
    private BordereauLivraison identifiantBL;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule_agent"),
            @JoinColumn(name = "code_corps_agent", referencedColumnName = "code_corps_agent")
    })
    private Agent matriculeAgent;

    @ManyToOne
    @JoinColumn(name = "code_section")
    private Sections codeSection;
}


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
    private Timestamp dateEnregistrement = new Timestamp(System.currentTimeMillis());

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


public class TypeObjet {

    @Id
    @Column(name = "code_type_objet", length = 5)
    private String codeTypeObjet;

    @Column(name = "libelle_type_objet", length = 100)
    private String libelleTypeObjet;

    @ManyToOne
    @JoinColumn(name = "code_section")
    private Sections codeSection;
}


public class TypeVehicule {

    @Id
    @Column(name = "code_type_vehicule", length = 25)
    private String codeTypeVehicule;

    @Column(name = "libelle_type_vehicule", length = 100)
    private String libelleTypeVehicule;
}


public class MarqueVehicule {

    @Id
    @Column(name = "code_marque", length = 25)
    private String codeMarque;

    @Column(name = "libelle_marque", length = 100)
    private String libelleMarque;
}


public class Vehicule {

    @Id
    @Column(name = "numero_serie", length = 30)
    private String numeroSerie;

    @Column(name = "numero_immatriculation", length = 20)
    private String numeroImmatriculation;

    @Column(name = "genre", length = 50)
    private String genre;

    @Column(name = "modele", length = 50)
    private String modele;

    @Column(name = "etat_vehicule", length = 10)
    private String etatVehicule;

    @Column(name = "type_energie", length = 20)
    private String typeEnergie;

    @Column(name = "numero_carte_grise", length = 30)
    private String numeroCarteGrise;

    @Column(name = "date_mise_en_circulation")
    private Date dateMiseEnCirculation;

    @ManyToOne
    @JoinColumn(name = "code_pays")
    private Pays codePays;

    @ManyToOne
    @JoinColumn(name = "code_type_vehicule")
    private TypeVehicule codeTypeVehicule;

    @ManyToOne
    @JoinColumn(name = "code_marque")
    private MarqueVehicule codeMarque;

    @ManyToOne
    @JoinColumn(name = "code_unite_douaniere")
    private UniteDouaniere codeUniteDouaniere;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "identifiant_b_e", referencedColumnName = "identifiant_b_e"),
            @JoinColumn(name = "code_article_bon_entree", referencedColumnName = "code_article_bon_entree")
    })
    private ArticleBonEntree identifiantBE;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "matricule_agent", referencedColumnName = "matricule_agent"),
            @JoinColumn(name = "code_corps_agent", referencedColumnName = "code_corps_agent")
    })
    private Agent matriculeAgent;

    @ManyToOne
    @JoinColumn(name = "code_type_objet")
    private TypeObjet codeTypeObjet;
}



----------------------------------------------------------------------------------------------------


SELECT * FROM information_schema.tables WHERE table_type = 'BASE TABLE';


DROP TABLE IF EXISTS vehicule;
DROP TABLE IF EXISTS article_bon_entree;
DROP TABLE IF EXISTS bon_entree;
DROP TABLE IF EXISTS bordereau_livraison;
DROP TABLE IF EXISTS agent;
DROP TABLE IF EXISTS type_objet;
DROP TABLE IF EXISTS sections;
DROP TABLE IF EXISTS unite_douaniere;
DROP TABLE IF EXISTS prestataires;
DROP TABLE IF EXISTS type_vehicule;
DROP TABLE IF EXISTS marque_vehicule;
DROP TABLE IF EXISTS type_unite_douaniere;
DROP TABLE IF EXISTS corps_agent;
DROP TABLE IF EXISTS fonction_agent;
DROP TABLE IF EXISTS pays;







----------------------------------------------------------------------------------------------------




CREATE TABLE fonction_agent (
    code_fonction_agent VARCHAR(10),
    libelle_fonction_agent VARCHAR(100),
    PRIMARY KEY (code_fonction_agent)
);

CREATE TABLE corps_agent (
    code_corps_agent VARCHAR(3),
    libelle_corps_agent VARCHAR(100),
    PRIMARY KEY (code_corps_agent)
);

CREATE TABLE type_unite_douaniere (
    code_type_unite_douaniere VARCHAR(5),
    libelle_type_unite_douaniere VARCHAR(100),
    PRIMARY KEY (code_type_unite_douaniere)
);

CREATE TABLE marque_vehicule (
    code_marque VARCHAR(25),
    libelle_marque VARCHAR(100),
    PRIMARY KEY (code_marque)
);

CREATE TABLE type_vehicule (
    code_type_vehicule VARCHAR(25),
    libelle_type_vehicule VARCHAR(100),
    PRIMARY KEY (code_type_vehicule)
);

CREATE TABLE prestataires (
    ninea VARCHAR(20),
    raison_sociale VARCHAR(512),
    numero_telephone INT,
    adresse VARCHAR(512),
    PRIMARY KEY (ninea)
);

CREATE TABLE unite_douaniere (
    code_unite_douaniere VARCHAR(3),
    nom_unite_douaniere VARCHAR(255),
    effectif_unite_douaniere INT,
    nombre_arme INT,
    nombre_automobile INT,
    nombre_materiel INT,
    code_type_unite_douaniere VARCHAR(5),
    PRIMARY KEY (code_unite_douaniere),
    CONSTRAINT FK_unite_douaniere_type_unite_douaniere FOREIGN KEY (code_type_unite_douaniere) REFERENCES type_unite_douaniere(code_type_unite_douaniere)
);


CREATE TABLE sections (
    code_section VARCHAR(3),
    libelle_section VARCHAR(100),
    code_unite_douaniere VARCHAR(3),
    PRIMARY KEY (code_section),
    CONSTRAINT FK_section_unite_douaniere FOREIGN KEY (code_unite_douaniere) REFERENCES unite_douaniere(code_unite_douaniere)
);

CREATE TABLE type_objet (
    code_type_objet VARCHAR(5),
    libelle_type_objet VARCHAR(100),
    code_section VARCHAR(3),
    PRIMARY KEY (code_type_objet),
    CONSTRAINT FK_type_objet_sections FOREIGN KEY (code_section) REFERENCES sections(code_section)
);



CREATE TABLE agent (
    matricule_agent VARCHAR(7),
    code_agent VARCHAR(5) UNIQUE,
    nom_agent VARCHAR(100),
    prenom_agent VARCHAR(255),
    numero_telephone_agent INT,
    code_fonction_agent VARCHAR(10),
    code_unite_douaniere VARCHAR(3),
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (matricule_agent, code_corps_agent),
    CONSTRAINT FK_agent_fonction_agent FOREIGN KEY (code_fonction_agent) REFERENCES fonction_agent(code_fonction_agent),
    CONSTRAINT FK_agent_unite_douaniere FOREIGN KEY (code_unite_douaniere) REFERENCES unite_douaniere(code_unite_douaniere),
    CONSTRAINT FK_agent_corps_agent FOREIGN KEY (code_corps_agent) REFERENCES corps_agent(code_corps_agent)
);


CREATE TABLE bordereau_livraison ( -- exemple : BLSA202311121243214 (SA+heure en timestamp)
    identifiant_b_l VARCHAR(25),
    numero_b_l VARCHAR(100),
    description_b_l VARCHAR(512),
    lieu_de_livraison VARCHAR(255),
    date_b_l DATE,
    conformite_b_l VARCHAR(3),
    nom_livreur VARCHAR(512),
    code_section VARCHAR(3),
    ninea VARCHAR(20),
    matricule_agent VARCHAR(7),
    date_enregistrement TIMESTAMP,
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (identifiant_b_l),
    CONSTRAINT FK_bordereau_livraison_sections FOREIGN KEY (code_section) REFERENCES sections(code_section),
    CONSTRAINT FK_bordereau_livraison_prestataires FOREIGN KEY (ninea) REFERENCES prestataires(ninea),
    CONSTRAINT FK_bordereau_livraison_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent)
);


CREATE TABLE bon_entree ( -- exemple : BESG202311121243214 (SG+heure en timestamp)
    identifiant_b_e VARCHAR(25),
    numero_b_e VARCHAR(100),
    libelle_bon_entree VARCHAR(255),
    date_bon_entree DATE,
    observation_bon_entree VARCHAR(255),
    identifiant_b_l VARCHAR(25),
    date_enregistrement TIMESTAMP,
    matricule_agent VARCHAR(7),
    code_corps_agent VARCHAR(3),
    code_section VARCHAR(3),
    PRIMARY KEY (identifiant_b_e),
    CONSTRAINT FK_bon_entree_bordereau_livraison FOREIGN KEY (identifiant_b_l) REFERENCES bordereau_livraison(identifiant_b_l),
    CONSTRAINT FK_bon_entree_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent),
    CONSTRAINT FK_bon_entree_sections FOREIGN KEY (code_section) REFERENCES sections(code_section)
);


CREATE TABLE article_bon_entree (
    identifiant_b_e VARCHAR(25),
    code_article_bon_entree INT,
    code_type_objet VARCHAR(5),
    libelle_article_bon_entree VARCHAR(255),
    quantite_entree INT,
    date_enregistrement TIMESTAMP,
    matricule_agent VARCHAR(7),
    code_corps_agent VARCHAR(3),
    PRIMARY KEY (identifiant_b_e, code_article_bon_entree),
    CONSTRAINT FK_article_bon_entree_bon_entree FOREIGN KEY (identifiant_b_e) REFERENCES bon_entree(identifiant_b_e),
    CONSTRAINT FK_article_bon_entree_type_objet FOREIGN KEY (code_type_objet) REFERENCES type_objet(code_type_objet),
    CONSTRAINT FK_article_bon_entree_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent)
);


CREATE TABLE pays (
    code_pays VARCHAR(3),
    libelle_pays VARCHAR(100),
    PRIMARY KEY (code_pays)
);


CREATE TABLE vehicule (
    numero_serie VARCHAR(30),
    numero_immatriculation VARCHAR(20),
    identifiant_b_e VARCHAR(25),
    code_article_bon_entree INT,
    genre VARCHAR(50),
    modele VARCHAR(50),
    etat_vehicule VARCHAR(10),
    type_energie VARCHAR(20),
    code_pays VARCHAR(3),
    numero_carte_grise VARCHAR(30),
    date_mise_en_circulation DATE,
    code_type_vehicule VARCHAR(25),
    code_marque VARCHAR(25),
    code_unite_douaniere VARCHAR(3),
    matricule_agent VARCHAR(7),
    code_corps_agent VARCHAR(3),
    code_type_objet VARCHAR(5),
    PRIMARY KEY (numero_serie),
    CONSTRAINT FK_vehicule_pays FOREIGN KEY (code_pays) REFERENCES pays(code_pays),
    CONSTRAINT FK_vehicule_article_bon_entree FOREIGN KEY (identifiant_b_e, code_article_bon_entree) REFERENCES article_bon_entree(identifiant_b_e, code_article_bon_entree),
    CONSTRAINT FK_vehicule_type_vehicule FOREIGN KEY (code_type_vehicule) REFERENCES type_vehicule(code_type_vehicule),
    CONSTRAINT FK_vehicule_marque_vehicule FOREIGN KEY (code_marque) REFERENCES marque_vehicule(code_marque),
    CONSTRAINT FK_vehicule_unite_douaniere FOREIGN KEY (code_unite_douaniere) REFERENCES unite_douaniere(code_unite_douaniere),
    CONSTRAINT FK_vehicule_agent FOREIGN KEY (matricule_agent, code_corps_agent) REFERENCES agent(matricule_agent, code_corps_agent),
    CONSTRAINT FK_vehicule_type_objet FOREIGN KEY (code_type_objet) REFERENCES type_objet(code_type_objet)
);





----------------------------------------------------------------------------------------------------



INSERT INTO fonction_agent (code_fonction_agent, libelle_fonction_agent)
VALUES ('FCT1', 'Fonction 1'),
       ('FCT2', 'Fonction 2'),
       ('FCT3', 'Fonction 3');


INSERT INTO corps_agent (code_corps_agent, libelle_corps_agent)
VALUES ('CP1', 'Corps 1'),
       ('CP2', 'Corps 2'),
       ('CP3', 'Corps 3');


INSERT INTO type_unite_douaniere (code_type_unite_douaniere, libelle_type_unite_douaniere)
VALUES ('BUR', 'BUREAU CENTRAL'),
       ('BRI', 'BRIGADE MOBILE');


INSERT INTO marque_vehicule (code_marque, libelle_marque)
VALUES ('MRQ1', 'Marque 1'),
       ('MRQ2', 'Marque 2'),
       ('MRQ3', 'Marque 3');


INSERT INTO type_vehicule (code_type_vehicule, libelle_type_vehicule)
VALUES ('TV1', 'Type 1'),
       ('TV2', 'Type 2'),
       ('TV3', 'Type 3');


INSERT INTO prestataires (ninea, raison_sociale, numero_telephone, adresse)
VALUES ('NIN1', 'Prestataire 1', 123456789, 'Address 1'),
       ('NIN2', 'Prestataire 2', 987654321, 'Address 2'),
       ('NIN3', 'Prestataire 3', 555555555, 'Address 3');


INSERT INTO unite_douaniere (code_unite_douaniere, nom_unite_douaniere, effectif_unite_douaniere, nombre_arme, nombre_automobile, nombre_materiel, code_type_unite_douaniere)
VALUES ('06K', 'BUREAU DE LA LOGISTIQUE ET DE LA MAINTENANCE', 10, 3, 5, 20, 'BUR'),
       ('06Z', 'BUREAU DE LA PROGRAMMATION ET DES FINANCES', 10, 3, 5, 20, 'BUR');


INSERT INTO sections (code_section, libelle_section, code_unite_douaniere)
VALUES ('SA', 'SECTION ARMEMENT', '06K'),
       ('SM', 'SECTION MATERIEL', '06K'),
       ('SG', 'SECTION GARAGE', '06K');


INSERT INTO type_objet (code_type_objet, libelle_type_objet, code_section)
VALUES ('ARMES', 'ARMES ET MUNITIONS', 'SA'),
       ('VEHIC', 'VEHICULES ET MATERIELS ROULANTS', 'SG');


INSERT INTO agent (matricule_agent, code_agent, nom_agent, prenom_agent, numero_telephone_agent, code_fonction_agent, code_unite_douaniere, code_corps_agent)
VALUES ('MAT001', 'AGT01', 'Nom Agent 1', 'Prenom Agent 1', 123456789, 'FCT1', '06K', 'CP1'),
       ('MAT002', 'AGT02', 'Nom Agent 2', 'Prenom Agent 2', 987654321, 'FCT2', '06Z', 'CP2'),
       ('MAT003', 'AGT03', 'Nom Agent 3', 'Prenom Agent 3', 555555555, 'FCT3', '06K', 'CP3');


INSERT INTO bordereau_livraison (identifiant_b_l, numero_b_l, description_b_l, lieu_de_livraison, date_b_l, conformite_b_l, nom_livreur, code_section, ninea, matricule_agent, date_enregistrement, code_corps_agent)
VALUES ('BL001', '001', 'Description BL 1', 'Lieu 1', '2023-12-01', 'Con', 'Livreur 1', 'SA', 'NIN1', 'MAT001', CURRENT_TIMESTAMP, 'CP1'),
       ('BL002', '002', 'Description BL 2', 'Lieu 2', '2023-12-02', 'Con', 'Livreur 2', 'SM', 'NIN2', 'MAT002', CURRENT_TIMESTAMP, 'CP2'),
       ('BL003', '003', 'Description BL 3', 'Lieu 3', '2023-12-03', 'Con', 'Livreur 3', 'SG', 'NIN3', 'MAT003', CURRENT_TIMESTAMP, 'CP3');


INSERT INTO bon_entree (identifiant_b_e, numero_b_e, libelle_bon_entree, date_bon_entree, observation_bon_entree, identifiant_b_l, date_enregistrement, matricule_agent, code_corps_agent, code_section)
VALUES ('BESA202312011043210', '001', 'Libelle BE 1', '2023-12-01', 'Observation 1', 'BL001', CURRENT_TIMESTAMP, 'MAT001', 'CP1', 'SA'),
       ('BESM202312021143211', '002', 'Libelle BE 2', '2023-12-02', 'Observation 2', 'BL002', CURRENT_TIMESTAMP, 'MAT002', 'CP2', 'SM'),
       ('BESG202312031243213', '003', 'Libelle BE 3', '2023-12-03', 'Observation 3', 'BL003', CURRENT_TIMESTAMP, 'MAT003', 'CP3', 'SG'),
       ('BESG202312040243216', '004', 'Libelle BE 4', '2023-12-03', 'Observation 4', 'BL003', CURRENT_TIMESTAMP, 'MAT003', 'CP3', 'SG');


INSERT INTO article_bon_entree (identifiant_b_e, code_article_bon_entree, code_type_objet, libelle_article_bon_entree, quantite_entree, date_enregistrement, matricule_agent, code_corps_agent)
VALUES ('BESA202312011043210', 1, 'ARMES', 'Article 1', 1, CURRENT_TIMESTAMP, 'MAT001', 'CP1'),
       ('BESM202312021143211', 2, 'VEHIC', 'Article 2', 1, CURRENT_TIMESTAMP, 'MAT002', 'CP2'),
       ('BESG202312031243213', 3, 'ARMES', 'Article 3', 1, CURRENT_TIMESTAMP, 'MAT003', 'CP3'),
       ('BESG202312031243213', 4, 'ARMES', 'Article 4', 1, CURRENT_TIMESTAMP, 'MAT003', 'CP3'),
       ('BESA202312011043210', 5, 'VEHIC', 'Article 5', 1, CURRENT_TIMESTAMP, 'MAT001', 'CP1');


INSERT INTO pays (code_pays, libelle_pays)
VALUES 
('AF', 'Afghanistan'),
('ZA', 'Afrique du Sud'),
('AX', 'Åland, Îles'),
('AL', 'Albanie'),
('DZ', 'Algérie'),
('DE', 'Allemagne'),
('DD', 'Allemagne de l''EST'),
('AD', 'Andorre'),
('AO', 'Angola'),
('AI', 'Anguilla'),
('AQ', 'Antarctique'),
('AG', 'Antigua et Barbuda'),
('AN', 'Antilles néerlandaises'),
('SA', 'Arabie Saoudite'),
('AR', 'Argentine'),
('AM', 'Arménie'),
('AW', 'Aruba'),
('AU', 'Australie'),
('AT', 'Autriche'),
('AZ', 'Azerbaïdjan'),
('BS', 'Bahamas'),
('BH', 'Bahrein'),
('BD', 'Bangladesh'),
('BB', 'Barbade'),
('BY', 'Bélarus'),
('BE', 'Belgique'),
('BZ', 'Bélize'),
('BJ', 'Bénin'),
('BM', 'Bermudes'),
('BT', 'Bhoutan'),
('BO', 'Bolivie (État plurinational de)'),
('BQ', 'Bonaire, Saint-Eustache et Saba'),
('BA', 'Bosnie-Herzégovine'),
('BW', 'Botswana'),
('BV', 'Bouvet, Ile'),
('BR', 'Brésil'),
('BN', 'Brunéi Darussalam'),
('BG', 'Bulgarie'),
('BF', 'Burkina Faso'),
('BI', 'Burundi'),
('CV', 'Cabo Verde'),
('KY', 'Caïmans, Iles'),
('KH', 'Cambodge'),
('CM', 'Cameroun'),
('CA', 'Canada'),
('CL', 'Chili'),
('CN', 'Chine'),
('CX', 'Christmas, île'),
('CY', 'Chypre'),
('CC', 'Cocos/Keeling (Îles)'),
('CO', 'Colombie'),
('KM', 'Comores'),
('CG', 'Congo'),
('CD', 'Congo, République démocratique du'),
('CK', 'Cook, Iles'),
('KR', 'Corée, République de'),
('KP', 'Corée, République populaire démocratique de'),
('CR', 'Costa Rica'),
('CI', 'Côte d''Ivoire'),
('HR', 'Croatie'),
('CU', 'Cuba'),
('CW', 'Curaçao'),
('DK', 'Danemark'),
('DJ', 'Djibouti'),
('DO', 'Dominicaine, République'),
('DM', 'Dominique'),
('EG', 'Egypte'),
('SV', 'El Salvador'),
('AE', 'Emirats arabes unis'),
('EC', 'Equateur'),
('ER', 'Erythrée'),
('ES', 'Espagne'),
('EE', 'Estonie'),
('US', 'Etats-Unis d''Amérique'),
('ET', 'Ethiopie'),
('FK', 'Falkland/Malouines (Îles)'),
('FO', 'Féroé, îles'),
('FJ', 'Fidji'),
('FI', 'Finlande'),
('FR', 'France'),
('GA', 'Gabon'),
('GM', 'Gambie'),
('GE', 'Géorgie'),
('GS', 'Géorgie du sud et les îles Sandwich du sud'),
('GH', 'Ghana'),
('GI', 'Gibraltar'),
('GR', 'Grèce'),
('GD', 'Grenade'),
('GL', 'Groenland'),
('GP', 'Guadeloupe'),
('GU', 'Guam'),
('GT', 'Guatemala'),
('GG', 'Guernesey'),
('GN', 'Guinée'),
('GW', 'Guinée-Bissau'),
('GQ', 'Guinée équatoriale'),
('GY', 'Guyana'),
('GF', 'Guyane française'),
('HT', 'Haïti'),
('HM', 'Heard, Ile et MacDonald, îles'),
('HN', 'Honduras'),
('HK', 'Hong Kong'),
('HU', 'Hongrie'),
('IM', 'Île de Man'),
('UM', 'Îles mineures éloignées des Etats-Unis'),
('VG', 'Îles vierges britanniques'),
('VI', 'Îles vierges des Etats-Unis'),
('IN', 'Inde'),
('IO', 'Indien (Territoire britannique de l''océan)'),
('ID', 'Indonésie'),
('IR', 'Iran, République islamique d'''),
('IQ', 'Iraq'),
('IE', 'Irlande'),
('IS', 'Islande'),
('IL', 'Israël'),
('IT', 'Italie'),
('JM', 'Jamaïque'),
('JP', 'Japon'),
('JE', 'Jersey'),
('JO', 'Jordanie'),
('KZ', 'Kazakhstan'),
('KE', 'Kenya'),
('KG', 'Kirghizistan'),
('KI', 'Kiribati'),
('KW', 'Koweït'),
('LA', 'Lao, République démocratique populaire'),
('LS', 'Lesotho'),
('LV', 'Lettonie'),
('LB', 'Liban'),
('LR', 'Libéria'),
('LY', 'Libye'),
('LI', 'Liechtenstein'),
('LT', 'Lituanie'),
('LU', 'Luxembourg'),
('MO', 'Macao'),
('MK', 'Macédoine, l''ex-République yougoslave de'),
('MG', 'Madagascar'),
('MY', 'Malaisie'),
('MW', 'Malawi'),
('MV', 'Maldives'),
('ML', 'Mali'),
('MT', 'Malte'),
('MP', 'Mariannes du nord, Iles'),
('MA', 'Maroc'),
('MH', 'Marshall, Iles'),
('MQ', 'Martinique'),
('MU', 'Maurice'),
('MR', 'Mauritanie'),
('YT', 'Mayotte'),
('MX', 'Mexique'),
('FM', 'Micronésie, Etats Fédérés de'),
('MD', 'Moldova, République de'),
('MC', 'Monaco'),
('MN', 'Mongolie'),
('ME', 'Monténégro'),
('MS', 'Montserrat'),
('MZ', 'Mozambique'),
('MM', 'Myanmar'),
('NA', 'Namibie'),
('NR', 'Nauru'),
('NP', 'Népal'),
('NI', 'Nicaragua'),
('NE', 'Niger'),
('NG', 'Nigéria'),
('NU', 'Niue'),
('NF', 'Norfolk, Ile'),
('NO', 'Norvège'),
('NC', 'Nouvelle-Calédonie'),
('NZ', 'Nouvelle-Zélande'),
('OM', 'Oman'),
('UG', 'Ouganda'),
('UZ', 'Ouzbékistan'),
('PK', 'Pakistan'),
('PW', 'Palaos'),
('PS', 'Palestine, Etat de'),
('PA', 'Panama'),
('PG', 'Papouasie-Nouvelle-Guinée'),
('PY', 'Paraguay'),
('NL', 'Pays-Bas'),
('XX', 'Pays inconnu'),
('ZZ', 'Pays multiples'),
('PE', 'Pérou'),
('PH', 'Philippines'),
('PN', 'Pitcairn'),
('PL', 'Pologne'),
('PF', 'Polynésie française'),
('PR', 'Porto Rico'),
('PT', 'Portugal'),
('QA', 'Qatar'),
('SY', 'République arabe syrienne'),
('CF', 'République centrafricaine'),
('RE', 'Réunion'),
('RO', 'Roumanie'),
('GB', 'Royaume-Uni de Grande-Bretagne et d''Irlande du Nord'),
('RU', 'Russie, Fédération de'),
('RW', 'Rwanda'),
('EH', 'Sahara occidental'),
('BL', 'Saint-Barthélemy'),
('KN', 'Saint-Kitts-et-Nevis'),
('SM', 'Saint-Marin'),
('MF', 'Saint-Martin (partie française)'),
('SX', 'Saint-Martin (partie néerlandaise)'),
('PM', 'Saint-Pierre-et-Miquelon'),
('VA', 'Saint-Siège'),
('VC', 'Saint-Vincent-et-les-Grenadines'),
('SH', 'Sainte-Hélène, Ascension et Tristan da Cunha'),
('LC', 'Sainte-Lucie'),
('SB', 'Salomon, Iles'),
('WS', 'Samoa'),
('AS', 'Samoa américaines'),
('ST', 'Sao Tomé-et-Principe'),
('SN', 'Sénégal'),
('RS', 'Serbie'),
('SC', 'Seychelles'),
('SL', 'Sierra Leone'),
('SG', 'Singapour'),
('SK', 'Slovaquie'),
('SI', 'Slovénie'),
('SO', 'Somalie'),
('SD', 'Soudan'),
('SS', 'Soudan du Sud'),
('LK', 'Sri Lanka'),
('SE', 'Suède'),
('CH', 'Suisse'),
('SR', 'Suriname'),
('SJ', 'Svalbard et île Jan Mayen'),
('SZ', 'Swaziland'),
('TJ', 'Tadjikistan'),
('TW', 'Taïwan, Province de Chine'),
('TZ', 'Tanzanie, République unie de'),
('TD', 'Tchad'),
('CS', 'Tchécoslovaquie'),
('CZ', 'Tchèque, République'),
('TF', 'Terres australes françaises'),
('TH', 'Thaïlande'),
('TL', 'Timor-Leste'),
('TG', 'Togo'),
('TK', 'Tokelau'),
('TO', 'Tonga'),
('TT', 'Trinité-et-Tobago'),
('TN', 'Tunisie'),
('TM', 'Turkménistan'),
('TC', 'Turks-et-Caïcos (Îles)'),
('TR', 'Turquie'),
('TV', 'Tuvalu'),
('UA', 'Ukraine'),
('SU', 'URSS'),
('UY', 'Uruguay'),
('VU', 'Vanuatu'),
('VE', 'Venezuela (République bolivarienne du)'),
('VN', 'Viet Nam'),
('VD', 'Viet Nam (Sud)'),
('WF', 'Wallis et Futuna'),
('YE', 'Yémen'),
('YU', 'Yougoslavie'),
('ZR', 'Zaïre'),
('ZM', 'Zambie'),
('ZW', 'Zimbabwe');



INSERT INTO vehicule (numero_serie, numero_immatriculation, identifiant_b_e, code_article_bon_entree, genre, modele, etat_vehicule, type_energie, code_pays, numero_carte_grise, date_mise_en_circulation, code_type_vehicule, code_marque, code_unite_douaniere, matricule_agent, code_corps_agent, code_type_objet)
VALUES ('123456', 'ABC123', 'BESM202312021143211', 2, 'Car', 'Model 1', 'Good', 'Gasoline', 'US', 'CG123', '2023-01-01', 'TV1', 'MRQ1', '06Z', 'MAT002', 'CP2', 'VEHIC'),
       ('789012', 'XYZ789', 'BESG202312031243213', 3, 'Truck', 'Model 2', 'Excellent', 'Diesel', 'JP', 'CG789', '2023-02-02', 'TV2', 'MRQ2', '06K', 'MAT003', 'CP3', 'ARMES'),
       ('345678', 'DEF345', 'BESA202312011043210', 1, 'Motorcycle', 'Model 3', 'Fair', 'Electric', 'FR', 'CG345', '2023-03-03', 'TV3', 'MRQ3', '06K', 'MAT001', 'CP1', 'VEHIC');










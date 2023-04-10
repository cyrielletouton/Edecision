DROP TABLE IF EXISTS teams;

CREATE TABLE teams (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  type enum ('DEVELOPPEMENT','ANALYSE_ET_CONCEPTION','PLANIFICATION','TEST_ET_DEPLOIEMENT','RECHERCHE','MAINTENANCE','COMMUNAUTE') default NOT NULL,
  derniereProposition DATE NULL
);

DROP TABLE IF EXISTS membres;

CREATE TABLE membres (
    utilisateur_id bigint default NULL,
    equipe_id bigint default NULL
);

DROP TABLE IF EXISTS projet;

CREATE TABLE projet (
    projet_id bigint default NULL,
    equipe_id bigint default NULL
);

DROP TABLE IF EXISTS teams;

CREATE TABLE teams (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  type enum ('DEVELOPPEMENT','ANALYSE_ET_CONCEPTION','PLANIFICATION','TEST_ET_DEPLOIEMENT','RECHERCHE','MAINTENANCE','COMMUNAUTE') default NOT NULL,
  derniereProposition DATE NULL
);

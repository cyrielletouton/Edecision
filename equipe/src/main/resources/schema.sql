DROP TABLE IF EXISTS teams;

CREATE TABLE teams (
  id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  type enum ('Développement','Analyse et conception','Planification','Test et déploiement','Recherche et état de l art','Veille et maintenance','Communauté') default NOT NULL,
  utilisateur varchar(255) default NULL,
  projet varchar(255) default NULL,
  derniereProposition DATE NULL
);
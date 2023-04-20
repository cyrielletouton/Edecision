DROP TABLE IF EXISTS projet;

CREATE TABLE projet (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nom varchar(255) default NOT NULL,
  equipes varchar(255) default NULL
);

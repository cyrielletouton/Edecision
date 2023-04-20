DROP TABLE IF EXISTS projet;

CREATE TABLE projet (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nom varchar(255) default NOT NULL,
  equipes varchar(255) default NULL
);
DROP TABLE IF EXISTS equipe;

CREATE TABLE equipe (
    projet_id bigint NOT NULL,
    equipe_id bigint NOT NULL
);
DROP TABLE IF EXISTS proposition;

CREATE TABLE proposition (
    projet_id bigint NOT NULL,
    proposition_id bigint NOT NULL
);

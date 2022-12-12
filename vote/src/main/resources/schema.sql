DROP TABLE IF EXISTS votes;

CREATE TABLE votes (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  statusutilisateur varchar(200) default NOT NULL,
  status enum ('ENCOURS','TERMINE') default NOT NULL,
  utilisateur varchar(200) NOT NULL,
  proposition varchar(200) not null
);
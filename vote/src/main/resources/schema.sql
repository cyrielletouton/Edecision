DROP TABLE IF EXISTS votes;

CREATE TABLE votes (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  status enum ('Pour','Contre', 'Abstention') default NOT NULL,
  utilisateur varchar(255) default NULL,
  proposition varchar(255) default NULL
);
DROP TABLE IF EXISTS votes;

CREATE TABLE votes (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  status enum ('POUR','CONTRE','ABSTENTION') default NOT NULL,
  membre varchar(200) NOT NULL,
  proposition varchar(200) not null
);

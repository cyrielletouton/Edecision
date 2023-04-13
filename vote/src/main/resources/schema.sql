DROP TABLE IF EXISTS votes;

CREATE TABLE votes (
                       id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
                       statu enum ('POUR','CONTRE','ABSTENTION') default NOT NULL,
                       membre int NOT NULL,
                       proposition int not null,
                       equipe int not null
);

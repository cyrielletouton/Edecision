INSERT INTO propositions (problematique,commentaire,status,estAccepte,impact,maxVote,nbrVote,dateDepot)
VALUES
    ('Problematique 1','Commentaire 1','OUVERT', false, 1, 10, 0, '2022-11-16'),
    ('Problematique 2','Commentaire 2','TERMINE', true, 1, 10, 10, '2022-11-10'),
    ('Problematique 3','Commentaire 3','TERMINE', false, 1, 5, 5, '2022-10-03'),
    ('Problematique 4','Commentaire 4','OUVERT', false, 1, 0, 0, '2022-11-16'),
    ('Problematique 5','Commentaire 5','ENCOURS', false, 1, 10, 1, '2022-11-16'),
    ('Problematique 6','Commentaire 6','TERMINE', true, 1, 10, 10, '2022-09-18');

INSERT INTO scope (scope_id,proposition_id)
VALUES
    ('5', '1'),
    ('5', '2'),
    ('1', '3'),
    ('2', '3'),
    ('3', '3'),
    ('5', '4'),
    ('5', '5'),
    ('1', '6');

INSERT INTO proprietaire (proprietaire_id,proposition_id)
VALUES
    ('4', '1'),
    ('1', '2'),
    ('2', '2'),
    ('3', '2'),
    ('4', '2'),
    ('5', '2'),
    ('6', '2'),
    ('7', '2'),
    ('8', '2'),
    ('9', '2'),
    ('10', '2'),
    ('2', '3'),
    ('3', '3'),
    ('2', '4'),
    ('3', '4'),
    ('2', '5'),
    ('3', '5'),
    ('10', '6');

INSERT INTO amendements (contenu)
VALUES
    ('Contenu 1'),
    ('Contenu 2'),
    ('Contenu 3'),
    ('Contenu 4'),
    ('Contenu 5');

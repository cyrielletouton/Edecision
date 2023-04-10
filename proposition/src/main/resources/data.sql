INSERT INTO propositions (problematique,commentaire,status,estAccepte,impact,maxVote,nbrVote,dateDepot)
VALUES
    ('Problematique 1','Commentaire 1','OUVERT', false, 1, 5, 0, '2022-11-16');

INSERT INTO scope (scope_id,proposition_id)
VALUES
    ('1', '1');

INSERT INTO proprietaire (proprietaire_id,proposition_id)
VALUES
    ('1', '1');

INSERT INTO amendements (contenu)
VALUES
    ('Contenu 1');

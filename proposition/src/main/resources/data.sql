INSERT INTO propositions (titre,description,status,estAccepte,impact,maxVote,nbrVote)
VALUES
    ('Titre 1','Description','OUVERT', false, 1, 5, 0);

INSERT INTO scope (scope_id,proposition_id)
VALUES
    ('1', '1');

INSERT INTO proprietaire (proprietaire_id,proposition_id)
VALUES
    ('1', '1');

INSERT INTO amendements (contenu)
VALUES
    ('Contenu 1');

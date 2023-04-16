INSERT INTO propositions (titre,description,statut,estAccepte,maxVote,nbrVote, nbrabstention, proprietaire, votants)
VALUES
    ('Titre 1','Description','ENCOURS', false, 5, 0, 0, 1, 0);

INSERT INTO equipes (equipe_id,proprietaire)
VALUES
    (1,1);

INSERT INTO amendements (contenu)
VALUES
    ('Contenu 1');

-- INSERT INTO votants (votants_id,equipe_id)
-- VALUES
--     (1,1);

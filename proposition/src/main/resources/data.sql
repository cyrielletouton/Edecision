INSERT INTO propositions (problematique,commentaire,status,estAccepte,impact,maxVote,nbrVote,proprietaire,scope,dateDepot)
VALUES
  ('Problematique 1','Commentaire 1','Ouvert', false, 1, 10, 0, '', '5', '2022-11-16'),
  ('Problematique 2','Commentaire 2','Terminé', true, 1, 10, 10, '1,2,3,4,5,6,7,8,9,10', '5', '2022-11-10'),
  ('Problematique 3','Commentaire 3','Terminé', false, 1, 5, 5, '2,3', '1,2,3', '2022-10-03'),
  ('Problematique 4','Commentaire 4','Ouvert', false, 1, 0, 0, '2,3', '5', '2022-11-16'),
  ('Problematique 5','Commentaire 5','En cours', false, 1, 10, 1, '2,3', '5', '2022-11-16'),
  ('Problematique 6','Commentaire 6','Terminé', true, 1, 10, 10, '10', '1', '2022-09-18')
 ;

INSERT INTO amendements (contenu)
VALUES
  ('Contenu 1'),
  ('Contenu 2'),
  ('Contenu 3'),
  ('Contenu 4'),
  ('Contenu 5')
;

INSERT INTO propositions_generales (proposition,amendement)
VALUES
  (1,1),
  (2,3),
  (3,5),
  (4,4),
  (5,2)
;
INSERT INTO members (nom,mdp,equipes)
VALUES
  ('Harriet Cooley','OUC49LFU7YT',1),
  ('Sheila Johns','VTV50BXN7GI',1),
  ('Rahim Martinez','ECK41DNJ0MS',1),
  ('Tad Morris','QPF54CXH1EI',1),
  ('Camden Browning','HVB19RPV8ID',1),
  ('Branden Chaney','WGA74OKD6YK',2),
  ('Oliver Nguyen','MBK33GMQ2BN',2),
  ('Shea Robinson','DNO21ZJC8NX',2),
  ('Aquila Gregory','JLM05CMU0ZR',2),
  ('Zia Wilkins','TFS82CES8XV',2);


INSERT INTO equipes (equipe_id,membre_id)
VALUES
    ('1','1'),
    ('1','2'),
    ('1','3'),
    ('1','4'),
    ('1','5'),
    ('2','6'),
    ('2','7'),
    ('2','8'),
    ('2','9'),
    ('2','10');




INSERT INTO propositions (proposition_id,membre_id)
VALUES
    ('1','1')

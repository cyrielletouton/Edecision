INSERT INTO teams (type,derniereProposition)
VALUES
    ('DEVELOPPEMENT','2022-01-01'),
    ('ANALYSE_ET_CONCEPTION', '2022-01-02');

INSERT INTO projet (projet_id,equipe_id)
VALUES
    ('1','1'),
    ('1','2');

INSERT INTO membres (membre_id,equipe_id)
VALUES
    ('1', '1'),
    ('2', '1'),
    ('3', '1'),
    ('4', '1'),
    ('5', '1'),
    ('6', '2'),
    ('7', '2'),
    ('8', '2'),
    ('9', '2'),
    ('10', '2');

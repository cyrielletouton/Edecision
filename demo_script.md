- Cette démonstration concerne un prototype qui permet de voter des propositions au sein de projet de la communauté E-DECISION
- Le prototype est une API développée avec Spring Boot selon une architecture micro-service, avec : 
  - un micro-service projet
  - un micro-service équipe
  - un micro-service membre
  - un micro-service proposition
  - un micro-service vote
  - un API-gateway pour la communication entre micro-service
  - une base de donnée H2 pour le moment, à remplacer par la technologie choisie pour le produit final

- Le prototype possède déjà quelques données afin de tester le bon fonctionnement de la base de donnée, 
mais pour la démo nous allons repartir de 0 pour montrer toutes les fonctionnalités

- Je vais vous présenter plusieurs vidéos qui résume le fonctionnement de l'outil

- Une première vidéo de mise en place : 
  - La communauté E-DECISION est un ensemble projets, donc pour initier cet écosystème on va créer des projets.
  - Ensuite on va créer des équipes et des utilisateurs que nous associerons à un projet.

- Une seconde vidéo où nous aborderons le vote d'une proposition et les différents cas de figure

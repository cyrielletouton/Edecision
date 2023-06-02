# Proposition de workflows

## Version simplifiée
- Pas d'amendement
- Pas d'escalade

POUR LA DEMO : 
1. Création d'un projet
   `http://localhost:8080/api/projet/create`
   `{
   "nom": "Projet DEMO",
   "equipes": ""
   }`
   * vérifier que le projet existe
   `http://localhost:8080/api/projet/get/2`
2. Création de deux équipes sur ce projet
   `http://localhost:8080/api/equipe/createMany`
   `[
   {
   "name" : "equipe 3",
   "typeEquipe": "DEVELOPPEMENT"
   },
   {
   "name" : "equipe 4",
   "typeEquipe": "ANALYSE_ET_CONCEPTION"
   }
   ]`
   * vérifier que les deux équipes existent
   `http://localhost:8080/api/equipe/get`
3. On ajoute l'équipe au projet
   `http://localhost:8080/api/equipe/give/3/projet/2`
   * vérifier que la composition de l'équipe (ajout du projet)
   `http://localhost:8080/api/equipe/get/3/composition`
4. Création de dix membres répartis dans les équipes
   `http://localhost:8080/api/membre/createMany`
   `[
   {
   "nom": "Membre A",
   "mdp": "passA",
   "equipe": 3
   },
   {
   "nom": "Membre B",
   "mdp": "passB",
   "equipe": 3
   },
   {
   "nom": "Membre C",
   "mdp": "passC",
   "equipe": 3
   },
   {
   "nom": "Membre D",
   "mdp": "passD",
   "equipe": 3
   },
   {
   "nom": "Membre E",
   "mdp": "passE",
   "equipe": 3
   },
   {
   "nom": "Membre F",
   "mdp": "passF",
   "equipe": 4
   },
   {
   "nom": "Membre G",
   "mdp": "passG",
   "equipe": 4
   },
   {
   "nom": "Membre H",
   "mdp": "passH",
   "equipe": 4
   },
   {
   "nom": "Membre I",
   "mdp": "passI",
   "equipe": 4
   },
   {
   "nom": "Membre J",
   "mdp": "passJ",
   "equipe": 4
   }
   ]
   `
   * vérifier que les membres existent
   `http://localhost:8080/api/membre/get`
   * vérifier que la composition est bonne (ajout des membres)
   `http://localhost:8080/api/equipe/get/3/composition`
5. Un membre crée une proposition
   `http://localhost:8080/api/proposition/create`
   `{
   "titre": "test",
   "description": "test",
   "statut": "OUVERTE",
   "estAccepte": false,
   "maxVote": 5,
   "nbrVote": 0,
   "nbrAbstention": 0,
   "proprietaire": 11,
   "projetId": 2,
   "votants": ""
   }`
   * vérifier que la proposition existe
   `http://localhost:8080/api/proposition/get/2`
   * vérifier la composition de la proposition
   `http://localhost:8080/api/proposition/get/2/composition`
   * get by equipe proposition (TODO)

6. Voter pour une proposition
   * Rendre la proposition votable
   `http://localhost:8080/api/proposition/update/2`
     `{
     "titre": "test",
     "description": "test",
     "statut": "ENCOURS",
     "estAccepte": false,
     "maxVote": 5,
     "nbrVote": 0,
     "nbrAbstention": 0,
     "proprietaire": 11,
     "projetId": 2,
     "votants": ""
     }`
   * Vote pour la proposition (x2)
   `http://localhost:8080/api/vote/create`
   `{
     "voteStatut": "POUR",
     "membre": 11,
     "proposition": 2,
     "equipe": 3
     }`
     `{
     "voteStatut": "POUR",
     "membre": 12,
     "proposition": 2,
     "equipe": 3
     }`
   * Vote contre la proposition (x2)
   * S'abstenir (x1)


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
3. On ajoute l'équipe au projet
   `http://localhost:8080/api/equipe/give/3/projet/2`
   * vérifier que la composition de l'équipe (ajout du projet)
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
   * Vote pour la proposition (x2)
   * Vote contre la proposition (x2)
   * S'abstenir (x1)


[//]: # (// OLD)

[//]: # (1. Avoir des utilisateurs)

[//]: # (   - **Existe en DB**)

[//]: # (2. Avoir une communauté &#40;l'ensemble des projets forment une communauté&#41;)

[//]: # (   * communauté = type d'équipe)

[//]: # (   * tous les utilisateurs existants sont dans la commununauté &#40;OK&#41;)

[//]: # (   - **Existe en DB**)

[//]: # (3. Créer une équipe &#40;par exemple équipe de développement&#41;)

[//]: # (   * ajouter des membres à l'équipe &#40;au moins 3 pour faire un vote&#41;)

[//]: # (   - **Existe en DB**)

[//]: # (4. Créer un projet )

[//]: # (   * ajouter le projet à la communauté)

[//]: # (   * ajouter une équipe au projet &#40;cf. 3.&#41;)

[//]: # (   - **Existe en DB**)

[//]: # (5. Créer une proposition)

[//]: # (   * supprimer la proposition &#40;exigence&#41;)

[//]: # (   * re-créer la proposition)

[//]: # (   - **Existe en DB**)

[//]: # (   - Problématique c'est quoi ? Une description des propositions ? Si oui est-ce que je peux le renommer en description ?)

[//]: # (   - Propriétaire c'est quoi ? C'est la liste des personnes concernées par la proposition ? C'est les personnes qui ont déposés la proposition ? Une proposition a UN SEUL propriétaire dans le cahier des charges, est-ce qu'il faudrait pas changer ça?)

[//]: # (6. Voter la proposition)

[//]: # (   - Les problèmes commencent ici : )

[//]: # (     - est-ce qu'on ajoute une liste de vote à chaque proposition &#40;un vote = un user&#41; et on calcule le statut de la proposition en fonction du nombre de votes ? Ensuite on complexifie en ajoutant une date limite, un nombre minimum de votant etc...)

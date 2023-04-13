# Proposition de workflows

## Version simplifiée
- Pas d'amendement
- Pas d'escalade

1. Avoir des utilisateurs
   - **Existe en DB**
2. Avoir une communauté (l'ensemble des projets forment une communauté)
   * communauté = type d'équipe
   * tous les utilisateurs existants sont dans la commununauté (OK)
   - **Existe en DB**
3. Créer une équipe (par exemple équipe de développement)
   * ajouter des membres à l'équipe (au moins 3 pour faire un vote)
   - **Existe en DB**
4. Créer un projet 
   * ajouter le projet à la communauté
   * ajouter une équipe au projet (cf. 3.)
   - **Existe en DB**
5. Créer une proposition
   * supprimer la proposition (exigence)
   * re-créer la proposition
   - **Existe en DB**
   - Problématique c'est quoi ? Une description des propositions ? Si oui est-ce que je peux le renommer en description ?
   - Propriétaire c'est quoi ? C'est la liste des personnes concernées par la proposition ? C'est les personnes qui ont déposés la proposition ? Une proposition a UN SEUL propriétaire dans le cahier des charges, est-ce qu'il faudrait pas changer ça?
6. Voter la proposition
   - Les problèmes commencent ici : 
     - est-ce qu'on ajoute une liste de vote à chaque proposition (un vote = un user) et on calcule le statut de la proposition en fonction du nombre de votes ? Ensuite on complexifie en ajoutant une date limite, un nombre minimum de votant etc...

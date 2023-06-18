A# Edecision
Edecision -IJVA500

Prérequis : utiliser intelliJ comme éditeur de code
(dire oui à toutes les pop-up intelliJ)

- Ouvrir projet existant depuis VCS
- Cloner le projet
- Configurer le bon SDK (JDK 17 Amazon Coretto)
  - File -> Open project structure -> project -> SDK -> download SDK (amazon coretto version 17)
- Onglet Gradle (à droite, vertical), faire reload all gradle projects (l'icône 'reload')
- Si le popup liés aux services apparaît en bas à droite, cliquez sur "Use Services"
- Dans l'onglet services (en bas), si vous n'avez pas 6 services (Equipe, Gateway,Membre, Projet,Proposition,Vote), allez dans le module correspondant dans src/main.java et faites clic droit/run sur la classe contenant la méthode main(), par exemple VoteApplication.java
- Dans l'onglet service, cliquez sur l'icone Run (ou COTRL+MAJ+F10) afin de lancer l'ensemble des services

Documentation des API d'un service donné accessible via ce chemin:
http://localhost:8080/api/NOMDUSERVICE/swagger-ui.html

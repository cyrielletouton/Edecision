@echo off

curl -X POST -H "Content-Type: application/json" -d "{\"nom\":\"Projet DEMO\",\"equipes\":[],\"propositions\":[]}" http://localhost:8080/api/projet/create


http://localhost:8080/api/equipe/createMany
[
  {
    "name" : "equipe 3",
    "typeEquipe": "DEVELOPPEMENT"
  },
  {
    "name" : "equipe 4",
    "typeEquipe": "ANALYSE_ET_CONCEPTION"
  }
]


http://localhost:8080/api/membre/createMany
[
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



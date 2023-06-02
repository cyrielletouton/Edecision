@echo off
echo "Creating a project"
curl -X POST -H "Content-Type: application/json" -d "{\"id\": 2, \"nom\": \"Projet DEMO\", \"equipes\": \"\"}" http://localhost:8080/api/projet/create & echo.
echo "Projet created"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Creating teams"
curl -X POST -H "Content-Type: application/json" -d "[{\"name\":\"equipe 3\",\"typeEquipe\":\"DEVELOPPEMENT\"},{\"name\":\"equipe 4\",\"typeEquipe\":\"ANALYSE_ET_CONCEPTION\"}]" http://localhost:8080/api/equipe/createMany & echo.
echo "Teams created"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Giving Project 2 to Team 3"
curl -X POST http://localhost:8080/api/equipe/give/3/projet/2 & echo.
echo "Project Given"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Creating 10 members"
curl -X POST -H "Content-Type: application/json" -d "[{\"nom\":\"Membre A\",\"mdp\":\"passA\",\"equipe\":3},{\"nom\":\"Membre B\",\"mdp\":\"passB\",\"equipe\":3},{\"nom\":\"Membre C\",\"mdp\":\"passC\",\"equipe\":3},{\"nom\":\"Membre D\",\"mdp\":\"passD\",\"equipe\":3},{\"nom\":\"Membre E\",\"mdp\":\"passE\",\"equipe\":3},{\"nom\":\"Membre F\",\"mdp\":\"passF\",\"equipe\":4},{\"nom\":\"Membre G\",\"mdp\":\"passG\",\"equipe\":4},{\"nom\":\"Membre H\",\"mdp\":\"passH\",\"equipe\":4},{\"nom\":\"Membre I\",\"mdp\":\"passI\",\"equipe\":4},{\"nom\":\"Membre J\",\"mdp\":\"passJ\",\"equipe\":4}]" http://localhost:8080/api/membre/createMany & echo.
echo "Members created"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Creating a proposition"
curl -X POST -H "Content-Type: application/json" -d "{\"titre\":\"test\",\"description\":\"test\",\"statut\":\"OUVERTE\",\"estAccepte\":false,\"maxVote\":5,\"nbrVote\":0,\"nbrAbstention\":0,\"proprietaire\":11,\"projetId\":2,\"votants\":\"\"}" http://localhost:8080/api/proposition/create & echo.
echo "Proposition created"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Updating a proposition"
curl -X POST -H "Content-Type: application/json" -d "{\"titre\":\"test\",\"description\":\"test\",\"statut\":\"ENCOURS\",\"estAccepte\":false,\"maxVote\":5,\"nbrVote\":0,\"nbrAbstention\":0,\"proprietaire\":11,\"projetId\":2,\"votants\":\"\"}" http://localhost:8080/api/proposition/update/2 & echo.
echo "Proposition updated"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 11 (POUR)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"POUR\",\"membre\":11,\"proposition\":2,\"equipe\":3}" http://localhost:8080/api/vote/create
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 12 (POUR)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"POUR\",\"membre\":12,\"proposition\":2,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 13 (CONTRE)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"CONTRE\",\"membre\":13,\"proposition\":2,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 14 (CONTRE)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"CONTRE\",\"membre\":14,\"proposition\":2,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 15 (ABSTENTION)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"ABSTENTION\",\"membre\":15,\"proposition\":2,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

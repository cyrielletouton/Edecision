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


@echo off
echo "Creating a proposition (VOTE CONTRE)"
curl -X POST -H "Content-Type: application/json" -d "{\"titre\":\"test\",\"description\":\"test\",\"statut\":\"OUVERTE\",\"estAccepte\":false,\"maxVote\":5,\"nbrVote\":0,\"nbrAbstention\":0,\"proprietaire\":11,\"projetId\":2,\"votants\":\"\"}" http://localhost:8080/api/proposition/create & echo.
echo "Proposition created"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Updating a proposition"
curl -X POST -H "Content-Type: application/json" -d "{\"titre\":\"test\",\"description\":\"test\",\"statut\":\"ENCOURS\",\"estAccepte\":false,\"maxVote\":5,\"nbrVote\":0,\"nbrAbstention\":0,\"proprietaire\":11,\"projetId\":2,\"votants\":\"\"}" http://localhost:8080/api/proposition/update/3 & echo.
echo "Proposition updated"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

@echo off
echo "Voting : member 11 (CONTRE)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"CONTRE\",\"membre\":11,\"proposition\":3,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 12 (CONTRE)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"CONTRE\",\"membre\":12,\"proposition\":3,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 13 (CONTRE)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"CONTRE\",\"membre\":13,\"proposition\":3,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 14 (CONTRE)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"CONTRE\",\"membre\":14,\"proposition\":3,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 15 (CONTRE)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"CONTRE\",\"membre\":15,\"proposition\":3,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

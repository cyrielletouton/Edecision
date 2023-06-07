@echo off
echo "Creating a proposition (VOTE ABSTENTION)"
curl -X POST -H "Content-Type: application/json" -d "{\"titre\":\"test\",\"description\":\"test\",\"statut\":\"OUVERTE\",\"estAccepte\":false,\"maxVote\":5,\"nbrVote\":0,\"nbrAbstention\":0,\"proprietaire\":11,\"projetId\":2,\"votants\":\"\"}" http://localhost:8080/api/proposition/create & echo.
echo "Proposition created"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Updating a proposition"
curl -X POST -H "Content-Type: application/json" -d "{\"titre\":\"test\",\"description\":\"test\",\"statut\":\"ENCOURS\",\"estAccepte\":false,\"maxVote\":5,\"nbrVote\":0,\"nbrAbstention\":0,\"proprietaire\":11,\"projetId\":2,\"votants\":\"\"}" http://localhost:8080/api/proposition/update/4 & echo.
echo "Proposition updated"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

@echo off
echo "Voting : member 11 (ABSTENTION)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"ABSTENTION\",\"membre\":11,\"proposition\":4,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 12 (ABSTENTION)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"ABSTENTION\",\"membre\":12,\"proposition\":4,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 13 (ABSTENTION)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"ABSTENTION\",\"membre\":13,\"proposition\":4,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 14 (ABSTENTION)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"ABSTENTION\",\"membre\":14,\"proposition\":4,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 15 (ABSTENTION)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"ABSTENTION\",\"membre\":15,\"proposition\":4,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

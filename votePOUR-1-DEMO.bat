echo "Voting : member 11 (POUR)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"POUR\",\"membre\":11,\"proposition\":2,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 12 (POUR)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"POUR\",\"membre\":12,\"proposition\":2,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 13 (POUR)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"POUR\",\"membre\":13,\"proposition\":2,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 14 (POUR)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"POUR\",\"membre\":14,\"proposition\":2,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

echo "Voting : member 15 (POUR)"
curl -X POST -H "Content-Type: application/json" -d "{\"voteStatut\":\"POUR\",\"membre\":15,\"proposition\":2,\"equipe\":3}" http://localhost:8080/api/vote/create & echo.
echo "Proposition voted"
echo "\-/-\-/-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/-\-/"

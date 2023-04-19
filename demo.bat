@echo off

curl -X POST -H "Content-Type: application/json" -d "{\"nom\":\"Projet DEMO\",\"equipes\":[],\"propositions\":[]}" http://localhost:8080/api/projet/create
# API REST doodle 

# Requirement 

jdk / jre
IDE

# Documentation 

void fichier [design](Design.md "design")
voir aussi la javadoc dans le dossier doc 

# logiciels :

ce projet à ete developper à l'aide de :

* Jersey : pour l'api Rest
* jpa / hibernate : pour la persistence des donnees
* Maven : pour la gestion des dependance 
* Hsql : comme base de donnees
* tomcat 7  comme server d'application
* Eclipse comme IDE 
* postman : pour tester notre api
* git / github : pour heberger notre code
* java :language de programmation 

# installation 

## lancer server tomcat :
projet > run As  >  maven Build .. > Goals :run -Dmaven.tomcat.port=8081

## lancer server base de donnees :
* double click sur run-hsqldb-server.bat

* double click sur show-hsqldb.bat
puis metez cette configuration 
type : HSQL Database Engine Server
URL  : jdbc:hsqldb:hsql://localhost:9004/

# Authors 

Abdrahmane EL MAHJOUB
Yaya SIMPARA
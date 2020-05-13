# API REST doodle 

# Requirement 

JDK / JRE / IDE

# Diagrammes 

voir fichier [design](Design.md "design").

# Java doc

voir [doc](doc "documentation"). 


# Api 

voir https://documenter.getpostman.com/view/4248959/SzmZd1V2

![api](images/api.PNG "api")

# logiciels :

ce projet à ete developper à l'aide de :

* java : langage de programmation 
* Jersey : pour l'api Rest
* jpa / hibernate : pour la persistence des donnees
* Maven : pour la gestion des dependance 
* Hsql : comme base de donnees
* tomcat 7 :  comme server d'application
* Eclipse  : comme IDE 
* postman : pour tester notre api
* git / github : pour heberger notre code
*etherpad : pour cree un pad en ligne et le partager.

# installations 

## lancer server tomcat :

projet > run As  >  maven Build .. > Goals

tomcat7:run -Dmaven.tomcat.port=8081

## lancer server base de donnees :

### windows

* double click sur run-hsqldb-server.bat

* double click sur show-hsqldb.bat

### linux 

* executer run-hsqldb-server.sh 

* executer show-hsqldb.sh


puis mettez cette configuration :

type : HSQL Database Engine Server

URL  : jdbc:hsqldb:hsql://localhost:9004/

## server de pad 

### windows

* telecharger ce dossier  https://etherpad.org/#download
* extraire 
* executer le fichier start.bat

copier le token pour acceder au server de pad dans config/ApiPadKey.txt ,
depuis le fichier ApiKey qui se trouve dans le dossier du  server.

### les autres systeme d'exploitation 

voir https://github.com/ether/etherpad-lite


#configuration 

remplir fichier config/mailConfig.txt
avec votre  compte mail et le mot de passe


# Authors 

Abdrahmane EL MAHJOUB

Yaya SIMPARA
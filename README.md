# API REST doodle 

# Requirement 

JDK / JRE / IDE

# Diagrammes 

voir fichier [design](Design.md "design").

# Java doc

voir [doc](doc "documentation"). 


# Api 

voir [api](https://documenter.getpostman.com/view/4248959/Szmk1aov "api") 


![api](images/api.PNG "api")

# technologies :

ce projet Ã  ete developper Ã  l'aide de :

* java : langage de programmation 
* Jersey : pour l'api Rest
* jpa / hibernate : pour la persistence des donnees
* Maven : pour la gestion des dependance 
* Hsql : comme base de donnees
* tomcat 7 :  comme server d'application
* Eclipse  : comme IDE 
* postman : pour tester notre api
* git / github : pour heberger notre code
* etherpad : pour cree un pad en ligne et le partager.

# installations 

## lancer server tomcat :

projet > run As  >  maven Build .. > Goals

tomcat7:run -Dmaven.tomcat.port=8081

## lancer server base de donnees :

### windows

* double click sur run-hsqldb-server.bat : pardefaut tourne sur le port 9004

* double click sur show-hsqldb.bat : choisir engine server et mettre *:9004* juste après localhost pour lui specifier le port du server hsql

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

*Plus de détail sur l'utilsation de pad avec java
https://github.com/nilsfr/java-etherpad-lite

### les autres systeme d'exploitation 

voir https://github.com/ether/etherpad-lite


# configuration 

*remplir fichier config/mailConfig.txt
avec votre  compte mail et le mot de passe, surtout si vous utilisez gmail de pas oubliez d'aller ![activer accès moins sécurisé des applications](images/gmail_secu.PNG"secu gmail") 


# Auteurs 

Abdrahmane EL MAHJOUB (welmahjoub sur github)

Yaya SIMPARA (ysimp sur github)
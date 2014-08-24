MediNetServices

## Quick start

First clone this project from github and navigate there from your command line/terminal.

**If you have gradle already installed**, just run `gradle build`
then you will find a **war** file in your projects **/build/libs/** folder. Deploy it in your favorite container e.g. tomcat.

**If you don't have gradle installed**, well, there is a awesome news for you! You don't need to download/install gradle to 
build this project! Here, [gradle wrapper](http://java.dzone.com/articles/use-gradle-wrapper-and-stop) is used to make your life easier ;)
All you have to do to run script, e.g. if you want to build this project, just execute following command from your terminal

* `./gradlew build ` (from Unix)
* `gradlew.bat build ` (from Windows)

This script will automatically determine your gradle installation or download & install gradle if required & then execute 
the gradle task, e.g. build war file for above command. To see the list of tasks available, use `./gradlew tasks` or `gradlew.bat tasks` 


## Quick development -> direct deploy app on embedded tomcat
Well, building project and deploying manually in app container sometimes become pain as these are repetitive work. To make 
your life easier, here embedded tomcat container has been integrated. Just type `gradle tomcatRunWar` in your command line 
and your project will build and run automatically on a tomcat container within a minute. You just have to go **http://localhost:8080/** from 
your browser to see it running. Cool...right? ;)


## Use of JRebel & App deployment in local Tomcat7
A Gradle task has been added to build war with JRebel support and deploy it to local tomcat container. It works only in Unix environment if you follow
below instructions:

1. Install [tomcat7](http://tomcat.apache.org/download-70.cgi) at **/usr/local/tomcat7** path.
2. Install jrebel at **/usr/local/JRebel** path.
3. Copy the script file from **config/catalina-jrebel.sh** in your **/usr/local/tomcat7/bin** directory
4. Run `gradle deployWar` in your source code which will copy the war file to tomcat's webapps folder
5. From /usr/local/tomcat7/bin, start tomcat server with command `./catalina-jrebel.sh run`
6. Browse application at [http://localhost:8080/MediNetServices/](http://localhost:8080/MediNetServices/)


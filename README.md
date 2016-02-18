[![Build Status](https://travis-ci.org/FabreFrederic/weatherStation.svg?branch=develop)](https://travis-ci.org/FabreFrederic/weatherStation)

# weatherStation
Weather Station allows you to save temperature reading.

How to build all the project modules :
cd weatherStation/weatherStation-maven
mvn clean install -U  

How to launch integration tests with remote debug :
export MAVEN_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,address=8100,server=y,suspend=y" && mvn clean install verify -U -P postgresql-it -DforkCount=0



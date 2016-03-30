[![Build Status](https://travis-ci.org/FabreFrederic/weatherStation.svg?branch=develop)](https://travis-ci.org/FabreFrederic/weatherStation)

# weatherStation
Weather Station allows you to save temperature reading.

How to build all the project modules :
cd weatherStation/weatherStation-maven
mvn clean install -U  

How to launch integration tests with remote debug :
Add options in docker.conf in DOCKER_OPTS
sudo vim /etc/default/docker
DOCKER_OPTS='-H tcp://0.0.0.0:4243 -H unix:///var/run/docker.sock'
Restart docker service
sudo service docker restart
Build a test docker image
cd weatherStation-integrationTest/src/test/resources/com/fabrefrederic/integrationTest/docker/postgresql/
docker build -t weatherstation/postgres-it .

Launch the command :
export MAVEN_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,address=8100,server=y,suspend=y" && mvn clean install verify -U -P postgresql-it -DforkCount=0



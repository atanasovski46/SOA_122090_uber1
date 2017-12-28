#!/bin/bash

cd task7-app1
mvn package docker:build
cd ..

cd task7-app2
mvn package docker:build
cd ..

cd task7-gateway
mvn package docker:build
cd ..

cd task7-eureka
mvn package docker:build
cd ..

cd task7-zuul
mvn package docker:build
cd ..

cd task7-login
mvn package docker:build
cd ..
 

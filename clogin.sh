#!/bin/bash

cd task7-login
mvn package docker:build

cd ..
docker-compose up -d


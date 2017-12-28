#!/bin/bash

cd task7-zuul
mvn package docker:build

cd ..
docker-compose up -d


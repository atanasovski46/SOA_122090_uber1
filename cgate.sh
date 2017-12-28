#!/bin/bash

cd task7-gateway
mvn package docker:build

cd ..
docker-compose up -d


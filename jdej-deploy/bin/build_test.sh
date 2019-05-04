#!/usr/bin/env bash
cd ../src/main/resources/config/
rm application.yml
echo "spring:" >> application.yml
echo "  profiles:" >> application.yml
echo "    active: test" >> application.yml

cd ../../../../../
mvn clean install
cd mcollege-deploy
mvn clean package


#!/bin/bash

bash download-opentracing-specialagent.sh

mvn -B clean package

docker-compose -f docker-compose-build.yaml build

docker-compose -f docker-compose.yaml up -d

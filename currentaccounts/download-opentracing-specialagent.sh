#!/bin/bash

if [ ! -f ./opentracing-specialagent-1.7.4.jar ]; then
    echo "File opentracing-specialagent-1.7.4.jar not found! and will be downloaded!"
    wget -O opentracing-specialagent-1.7.4.jar "https://repo1.maven.org/maven2/io/opentracing/contrib/specialagent/opentracing-specialagent/1.7.4/opentracing-specialagent-1.7.4.jar"
else
    echo "File opentracing-specialagent-1.7.4.jar found! and no download is needed!"
fi

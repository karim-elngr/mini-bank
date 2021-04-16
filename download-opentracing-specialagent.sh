#!/bin/bash

if [ ! -f ./currentaccounts/opentelemetry-javaagent-all.jar ]; then
    echo "File opentelemetry-javaagent-all.jar not found! and will be downloaded!"
    wget -O ./currentaccounts/opentelemetry-javaagent-all.jar "https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent-all.jar"
else
    echo "File opentelemetry-javaagent-all.jar found! and no download is needed!"
fi

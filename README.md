# mini-bank

[![ACCOUNTS_CI](https://github.com/karim-elngr/mini-bank/actions/workflows/accounts_ci.yml/badge.svg)](https://github.com/karim-elngr/mini-bank/actions/workflows/accounts_ci.yml)
[![codecov](https://codecov.io/gh/karim-elngr/mini-bank/branch/main/graph/badge.svg?token=yuMqn8a55A)](https://codecov.io/gh/karim-elngr/mini-bank)

A sample banking app, providing minimal functionality

## Build project `currentaccounts`
### Step by step option
1. Run build using maven
```
mvn clean package
```
2. Download the opentelemtry java agent
```
./download_opentracing_specialagent.sh
```
3. Run docker-compose build
```
docker-compose -f docker-compose-build.yaml build
```
4. Run docker-compose up
```
docker-compose -f docker-compose.yaml up -d   
```
### Script to run all steps
1. Run the following script alternatively to accomplish the same result
```
./start-docker.sh
```

## Test using postman
1. Import the postman collection located inside the `currentaccounts` directory
2. Execute requests against the `currentaccounts` REST API

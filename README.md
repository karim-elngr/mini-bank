# mini-bank

[![ACCOUNTS_CI](https://github.com/karim-elngr/mini-bank/actions/workflows/accounts_ci.yml/badge.svg)](https://github.com/karim-elngr/mini-bank/actions/workflows/accounts_ci.yml)
[![codecov](https://codecov.io/gh/karim-elngr/mini-bank/branch/main/graph/badge.svg?token=yuMqn8a55A)](https://codecov.io/gh/karim-elngr/mini-bank)

A sample banking app, providing minimal functionality

## Build project `currentaccounts`

<hr>

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
### Alternatively there is a script to run all steps
1. Run the following script to accomplish the same result
```
./start-docker.sh
```

<hr>

## Test using postman
1. Import the postman collection located inside the `currentaccounts` directory
2. Execute requests against the `currentaccounts` REST API

<hr>

## View tracing data
1. Visit [http://localhost:16686/search](http://localhost:16686/search) and observe tracing data using Jaeger UI

<hr>

## To-Do List
1. Implement transactions service using the [outbox pattern](https://debezium.io/blog/2019/02/19/reliable-microservices-data-exchange-with-the-outbox-pattern/) and [Change Data Capture](https://en.wikipedia.org/wiki/Change_data_capture) via [Debezium](https://debezium.io) and [Apache Kafka](https://kafka.apache.org). Here is an excellent article discussing the implementation [Saga Orchestration for Microservices Using the Outbox Pattern](https://www.infoq.com/articles/saga-orchestration-outbox/)

2. Implement a REST endpoint on transactions servie in order to get all transactions belonging to a single account, and complete the missing get current account details endpoint, by augmenting data from the transactions service.

3. Add a nice front end.

4. Add more integration tests, and support acceptance / smoke tests.

5. Add support for building docker containers in GitHub actions.

6. Use Flyway migrations.

7. Provision sample AWS k8s cluster.

8. Add GitHub manually triggerd actions to deploy application to AWS k8s cluster.

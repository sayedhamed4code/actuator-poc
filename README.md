# ActuatorPoc

`ActuatorPoc` is a small Spring Boot 3.3.0 proof-of-concept that demonstrates a reusable Actuator setup for REST-style microservices.

It includes:
- common Actuator endpoints for all services
- extra `dev`-only endpoints for local troubleshooting
- a Spring Boot Admin UI at `/admin`
- a sample custom health indicator
- reusable `/actuator/info` metadata
- a few simple sample APIs for testing mappings and metrics

## QuickStart

The application runs locally on port `8080` by default.

Clone the repository:

```powershell
git clone https://github.com/sayedhamed4code/actuator-poc.git
cd actuator-poc
```

Run with the default profile:

```powershell
.\mvnw.cmd spring-boot:run
```

Then open the Admin UI:

```text
http://localhost:8080/admin
```

Run with the `dev` profile:

```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=dev"
```

Run with the `prod` profile:

```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=prod"
```

Run with the `demo-down` profile to simulate a failing dependency:

```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.profiles=demo-down"
```

Run on a different port:

```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.arguments=--server.port=8081"
```

## Endpoints

Spring Boot Admin UI:
- `/admin`

Common endpoints:
- `/actuator`
- `/actuator/health`
- `/actuator/info`
- `/actuator/metrics`
- `/actuator/prometheus`
- `/actuator/loggers`

`dev` profile only:
- `/actuator/env`
- `/actuator/mappings`

Sample API endpoint:
- `/api/dummy`
- `/api/greetings`
- `/api/greetings/{name}`
- `/api/operations/summary`

Full URL example:
- `http://localhost:8080/actuator/health`

Default profile:

```text
http://localhost:8080/actuator
http://localhost:8080/actuator/health
http://localhost:8080/actuator/info
http://localhost:8080/actuator/metrics
http://localhost:8080/actuator/prometheus
http://localhost:8080/actuator/loggers
http://localhost:8080/admin
http://localhost:8080/api/dummy
http://localhost:8080/api/greetings?name=Ali
http://localhost:8080/api/operations/summary
```

`dev` profile:

```text
http://localhost:8080/actuator
http://localhost:8080/actuator/health
http://localhost:8080/actuator/info
http://localhost:8080/actuator/metrics
http://localhost:8080/actuator/prometheus
http://localhost:8080/actuator/loggers
http://localhost:8080/actuator/env
http://localhost:8080/actuator/mappings
http://localhost:8080/admin
http://localhost:8080/api/dummy
http://localhost:8080/api/greetings?name=Ali
http://localhost:8080/api/operations/summary
```

`prod` profile:

```text
http://localhost:8080/actuator
http://localhost:8080/actuator/health
http://localhost:8080/actuator/info
http://localhost:8080/actuator/metrics
http://localhost:8080/actuator/prometheus
http://localhost:8080/actuator/loggers
http://localhost:8080/admin
http://localhost:8080/api/dummy
http://localhost:8080/api/greetings?name=Ali
http://localhost:8080/api/operations/summary
```

`demo-down` profile:

```text
http://localhost:8080/actuator
http://localhost:8080/actuator/health
http://localhost:8080/actuator/info
http://localhost:8080/actuator/metrics
http://localhost:8080/actuator/prometheus
http://localhost:8080/actuator/loggers
http://localhost:8080/admin
http://localhost:8080/api/dummy
http://localhost:8080/api/greetings?name=Ali
http://localhost:8080/api/operations/summary
```

## Project Structure

```text
src/main/java/com/example/actuatorpoc
|-- ActuatorPocApplication.java
|-- actuator
|   |-- health
|   |   `-- SampleDependencyHealthIndicator.java
|   `-- info
|       `-- CustomInfoContributor.java
`-- controller
    |-- DummyController.java
    |-- GreetingController.java
    `-- OperationsController.java
```

## Notes

- `/actuator/env` is intentionally limited to `dev`
- `/actuator/mappings` is intentionally limited to `dev`
- `/admin` provides a browser UI for the registered application and its actuator endpoints
- the sample health indicator is controlled by `monitoring.sample-dependency.available`
- the `demo-down` profile flips `monitoring.sample-dependency.available=false` to demonstrate a `DOWN` health response
- the `prod` profile sets `management.endpoint.health.show-details=never` for a stricter health response
- `/actuator/info` is populated from `info.app.*` properties and `CustomInfoContributor`

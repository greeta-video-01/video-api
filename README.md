### 📖 Full-Stack Templates For Spring Boot Developers

#### ✅ Brand Shop UI with React, Angular, Netflix DGS GraphQL, Minio Image Upload and Resizing Server, Spring Security WebSockets and Keycloak Authorization Server
#### ✅ eCommerce Platform with Axon Event Sourcing CQRS, MongoDB Event Store and Kafka Event Streaming

<ul style="list-style-type:disc">
    <li>📖 This <b>Full-Stack Developer Template</b> provides fully functional Development Environment:</li>
    <li>📖 <b>Event-Driven Spring Boot Microservices</b> with Axon Event Sourcing CQRS, MongoDB Event Store and Kafka Event Streaming</li>
    <li>📖 <b>Swagger UI Gateway</b> with Keycloak Authorization</li>
    <li>📖 <b>React And Angular UI</b> with Netflix DGS GraphQL, Minio Image Upload and Resizing Server, Keycloak Authorization and Secured Websockets</li>
    <li>📖 Local <b>Docker</b> Development Environment</li>
  <li>📖 Full <b>Technology Stack</b>:</li>
  <ul>
    <li>✅ <b>Swagger UI Gateway</b></li>
    <li>✅ <b>React UI</b></li>
    <li>✅ <b>Angular UI</b></li>
    <li>✅ <b>Netflix DGS GraphQL</b></li>
    <li>✅ <b>Minio Image Upload and Resizing Server</b></li>
    <li>✅ <b>Spring Boot 3</b></li>
    <li>✅ <b>Spring Cloud Gateway</b></li>
    <li>✅ <b>Spring Security Websockets</b></li>
    <li>✅ <b>Secured Websockets Messaging with JWT</b></li>
    <li>✅ <b>Event-Driven Microservices</b></li>
    <li>✅ <b>Axon Event Sourcing</b></li>
    <li>✅ <b>MongoDB Event Store</b></li>
    <li>✅ <b>Kafka Event Streaming</b></li>
    <li>✅ <b>Axon CQRS</b></li>
    <li>✅ <b>Axon Saga Transactions</b></li>
    <li>✅ <b>CQRS Query Projection with PostgreSQL Database</b></li>
    <li>✅ <b>Keycloak Oauth2 Authorization Server</b></li>
    <li>✅ <b>Local Docker Environment</b></li>
    <li>✅ <b>Remote Debugging</b></li>
    <li>✅ <b>Zipkin Distributed Tracing</b></li>
  </ul>
</ul>

### 📖 Links

UI Repository is available Here: [Eshop UI](https://github.com/greeta-eshop-01/eshop-ui)

Spring Boot API Repository is available Here: [Eshop API](https://github.com/greeta-eshop-01/eshop-api)

See original eShop Code for Full-Stack Template with Gradle + React and Angular UI: [Original eShop](https://github.com/hdimitrieski/e-shop)

See previous Spring Boot Template for AWS Setup: [Twitter Kafka Analytics Platform](https://github.com/greeta-twitter-01/twitter-api)

### 📖 Step By Step Guide

#### Local Docker Environment Setup:

```
sh docker-start.sh
```

- this script will build all spring boot docker images and start environment with your code changes

```
sh docker-restart.sh
```

- this script will restart all docker containers without rebuilding images

```
sh docker-app-restart.sh order-processing
```

- this script will rebuild spring boot docker image for `order-processing` application and restart application with rebuilt image
- replace `order-processing` with the name of the application you want to rebuild and restart


#### React and Angular UI setup:

UI Repository is available Here: [Eshop UI](https://github.com/greeta-eshop-01/eshop-ui)

- `ng-rest-client` Setup:

```
export NODE_OPTIONS=--openssl-legacy-provider
npm install
ng serve
```

- `react-graphql-client` Setup:

```
npm install
npm start
```


#### Local Docker Environment Acceptance Test:

- open http://localhost:9000 in your Browser and switch between Swagger UI Pages

- For authorized requests: click `Authorize` and use `admin/admin` or `user/user` for credentials (`clientId` should be `stock-app`)

- open http://localhost:4200 in your Browser and test Angular UI 

- open http://localhost:4201 in your Browser and test React GraphQL UI

- Use `admin/admin` or `user/user` for credentials

- Make sure that `Keycloak Authorization` and `WebSocket Connections` are working correctly for these pages

- Warning! If Swagger UI fails to load on the first try, please, refresh the page!

- Warning! Sometimes switching between Swagger UI pages doesn't refresh Swagger UI completely and you might see wrong REST endpoints: just refresh the page and continue

- Warning! Sometimes REST endpoints return `504 Gateway Timeout`, just retry the REST API endpoint again

- Congratulations! You successfully tested `Swagger UI Gateway`, `Angular UI` and `React GraphQL UI`


### Remote Debugging

![Configuration to debug a containerized Java application from IntelliJ IDEA](documentation/06-14.png)

#### Minio Image Upload and Resizing Server

- Minio Image Upload and Resizing Server is available here: http://localhost:8086/

- Make sure that `customer-images` Bucket exists and contains Brand Product Images

- You can download and browse images using this console


#### Zipkin Server

- Zipkin Server for Distributed Tracing is available here: http://localhost:9411/

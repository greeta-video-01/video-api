### 📖 Full-Stack Templates For Spring Boot Developers

#### ✅ Video Streaming Platform with Debezium CDC Kafka Connector, Kafka Event Streaming, Minio File Storage and FFmpeg Video Processing

<ul style="list-style-type:disc">
    <li>📖 This <b>Full-Stack Developer Template</b> provides fully functional Development Environment:</li>
    <li>📖 <b>Event-Driven Spring Boot Microservices</b> with Debezium Change Data Capture, Debezium Kafka Connector and Kafka Event Streaming</li>
    <li>📖 <b>Swagger UI Gateway</b> with Keycloak Authorization</li>
    <li>📖 <b>Video Streaming API</b> with Minio File Storage, PostgreSQL Event and Metadata Persistence, Redis Cache Manager, Debezium Change Data Capture and FFmpeg Video Processing</li>
    <li>📖 Custom <b>Spring Boot Docker Image</b> with pre-installed FFmpeg Video Processing Tool</li>
    <li>📖 Local <b>Docker</b> Development Environment</li>
  <li>📖 Full <b>Technology Stack</b>:</li>
  <ul>
    <li>✅ <b>Swagger UI Gateway</b></li>
    <li>✅ <b>Debezium PostgreSQL Change Data Capture</b></li>
    <li>✅ <b>PostgreSQL Event and Metadata Persistence</b></li>
    <li>✅ <b>Debezium Kafka Connector</b></li>
    <li>✅ <b>Minio File Storage Server</b></li>
    <li>✅ <b>Redis Cache Manager</b></li>
    <li>✅ <b>Spring Boot 3</b></li>
    <li>✅ <b>Spring Cloud Gateway</b></li>
    <li>✅ <b>Kafka Transactional Event Streaming</b></li>
    <li>✅ <b>FFmpeg Video Processing Tool</b></li>
    <li>✅ <b>Event-Driven Microservices</b></li>
    <li>✅ <b>Kafka Event Store</b></li>
    <li>✅ <b>Kafka UI</b></li>
    <li>✅ <b>Keycloak Oauth2 Authorization Server</b></li>
    <li>✅ <b>Local Docker Environment</b></li>
    <li>✅ <b>Remote Debugging</b></li>
    <li>✅ <b>Zipkin Distributed Tracing</b></li>
  </ul>
</ul>

### 📖 Links

See original spring-video HLS video streaming application: [Spring Video](https://github.com/joejoe2/spring-video)

See previous Spring Boot Template for AWS Setup Example: [Twitter Kafka Analytics Platform](https://github.com/greeta-twitter-01/twitter-api)

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
sh docker-app-restart.sh video
```

- this script will rebuild spring boot docker image for `video` application and restart application with rebuilt image
- replace `video` with the name of the application you want to rebuild and restart

```
sh docker-worker-restart.sh
```

- this script will rebuild spring boot docker image for `worker` application and restart application with rebuilt image
- `worker` uses custom Dockerfile image to pre-install FFmpeg Tool. Therefore, it should be rebuilt with custom script
- actual rebuild of `worker` docker image happens in `docker-app-compose.yml` file (see `build: "./worker-service"`)


#### Local Docker Environment Acceptance Test:

1. run `sh docker-start.sh`

2. run commands in `./command.txt` (Debezium Kafka PostgreSQL connectors)

3. open http://localhost:9000 in your Browser

- For authorized requests: click `Authorize` and use `admin/admin` or `user/user` for credentials (`clientId` should be `video-app`)

4. goto http://localhost:9000/webjars/swagger-ui/index.html#/storage-controller/upload and upload mp4 file (you can use `test.mp4` in `worker-service` folder for testing)

5. goto http://localhost:9000/webjars/swagger-ui/index.html#/video-controller/create and create video with filename from step 4, please copy the video id from response

6. goto http://localhost:9000/webjars/swagger-ui/index.html#/video-controller/profile with video id and wait for the video status to become READY

7. use http://localhost:9000/video/api/video/{your_video_id}/index.m3u8 for any HLS player (alternatively, download links in `m3u8` file and open them with any video player)


- Congratulations! You successfully tested `Swagger UI Gateway` and `Video Streaming API`!


### Remote Debugging

![Configuration to debug a containerized Java application from IntelliJ IDEA](documentation/06-14.png)

#### Minio File Storage Server

- Minio File Storage Server should be available here: http://localhost:8086/

- If acceptance testing was successful, then `stream` and `video` Buckets should exist and contain video files

- You can download and browse video files using this console

#### Kafka UI

- Kafka UI should be available here: http://localhost:8070/
- You can browse topics, partitions, messages and other kafka resources using this console

#### Zipkin Server

- Zipkin Server for Distributed Tracing should be available here: http://localhost:9411/

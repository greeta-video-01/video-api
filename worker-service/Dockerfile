FROM openjdk:17-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN apt-get update && apt-get install -y ffmpeg
CMD ["java", "-jar", "application.jar"]
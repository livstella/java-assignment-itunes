FROM maven:3-jdk-14 AS maven
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:14
COPY --from=maven /home/app/target/java-assignment-itunes.jar /
ENTRYPOINT [ "java", "-jar", "java-assignment-itunes.jar" ]
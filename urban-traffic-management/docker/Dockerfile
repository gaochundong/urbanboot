# Build the application artifact
FROM maven:3.6.3-jdk-8 as build
COPY . /urbanboot
WORKDIR /urbanboot/urban-traffic-management

RUN mvn clean package

# Start with a base image containing Java runtime
FROM adoptopenjdk:8-jre-hotspot-bionic

# The application's jar file
ARG APP_CATEGORY="urbanboot"
ARG APP_FOLDER="urban-traffic-management"
ARG APP_NAME="urban-traffic-management-app"
ARG APP_JAR_FILE="${APP_NAME}-*-exec.jar"

# Copy the application's jar to the container
COPY --from=build /urbanboot/urban-traffic-management/urban-traffic-management-app/target/${APP_JAR_FILE} /opt/${APP_CATEGORY}/${APP_FOLDER}/${APP_NAME}.jar

# Set the working directory
ENV APP_HOME /opt/${APP_CATEGORY}/${APP_FOLDER}
WORKDIR ${APP_HOME}

# Informs the container listens on the specified network ports at runtime
EXPOSE 7200/tcp

# Signal to exit
STOPSIGNAL SIGTERM

# Run the jar file
ENTRYPOINT [ \
    "java", \
    "-server", \
    "-jar", \
    "-Xmn64M", \
    "-Xms64M", \
    "-Xmx1024M", \
    "-Dserver.port=7200", \
    "-Dspring.cloud.consul.enabled=false", \
    "-Dspring.cloud.kubernetes.enabled=false", \
    "-Dspring.cloud.kubernetes.ribbon.enabled=false", \
    "-Duser.dir=/opt/urbanboot/urban-traffic-management", \
    "/opt/urbanboot/urban-traffic-management/urban-traffic-management-app.jar"]
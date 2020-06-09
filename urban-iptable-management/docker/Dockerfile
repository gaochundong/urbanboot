# Build the application artifact
FROM maven:3.6.3-jdk-8 as build
COPY . /urbanboot/
WORKDIR /urbanboot/urban-iptable-management/

RUN mvn -s /urbanboot/settings.xml clean package

# Start with a base image containing Java runtime
FROM adoptopenjdk:8u252-b09-jre-hotspot-bionic

# The application's jar file
ARG APP_CATEGORY="urbanboot"
ARG APP_FOLDER="urban-iptable-management"
ARG APP_NAME="urban-iptable-management-app"
ARG APP_JAR_FILE="${APP_NAME}-*-exec.jar"

# Copy the application's jar to the container
COPY --from=build /urbanboot/urban-iptable-management/urban-iptable-management-app/target/${APP_JAR_FILE} /opt/${APP_CATEGORY}/${APP_FOLDER}/${APP_NAME}.jar

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
    "-Dspring.cloud.kubernetes.enabled=true", \
    "-Dspring.cloud.kubernetes.ribbon.enabled=true", \
    "-Duser.dir=/opt/urbanboot/urban-iptable-management", \
    "/opt/urbanboot/urban-iptable-management/urban-iptable-management-app.jar"]
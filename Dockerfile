FROM adoptopenjdk/openjdk11:ubi
VOLUME /tmp
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/*.jar app.jar
EXPOSE 8090
CMD ["java", "-jar", "app.jar"]
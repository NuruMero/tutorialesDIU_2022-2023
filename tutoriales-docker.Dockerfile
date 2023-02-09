FROM openjdk:17

COPY target/tutorial-0.0.1-SNAPSHOT.jar /tutorialapp.jar

CMD ["java", "-jar", "/tutorialapp.jar"]
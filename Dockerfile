FROM adoptopenjdk/openjdk8:alpine-jre
ADD target/ResumeMatcher-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java","-war","app.war"]
FROM maven:3.6.0-jdk-8
RUN  mkdir /docker
WORKDIR /docker
COPY pom.xml .
ADD target/jarfiledemoProject-0.0.1-SNAPSHOT.jar jarfiledemoProject-0.0.1-SNAPSHOT.jar
COPY . .
ENTRYPOINT ["/bin/sh", "-c" ,"java -jar jarfiledemoProject-0.0.1-SNAPSHOT.jar testng.xml && trap : TERM INT; sleep infinity & wait"]

FROM java:8
LABEL maintainer=“harshanand@rsystems.com”
EXPOSE 8761
ADD target/EurekaServer-0.0.1-SNAPSHOT.jar EurekaServer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","EurekaServer-0.0.1-SNAPSHOT.jar"]
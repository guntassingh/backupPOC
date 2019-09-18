FROM java:8
LABEL maintainer=“harshanand@rsystems.com”
EXPOSE 8080
ADD target/ZuulGatewayService-0.0.1-SNAPSHOT.jar ZuulGatewayService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ZuulGatewayService-0.0.1-SNAPSHOT.jar"]
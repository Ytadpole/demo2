FROM registry.cn-shenzhen.aliyuncs.com/library-jdk/jdk

VOLUME /tmp

ADD  target/demo2-0.0.1-SNAPSHOT.jar /demo2-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar" ,"/demo2-0.0.1-SNAPSHOT.jar"]

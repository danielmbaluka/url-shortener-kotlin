FROM openjdk:11-jdk

RUN mkdir -p /usr/app

RUN mkdir -p /usr/src/app

WORKDIR /usr/app


COPY ./start.sh /usr/app
COPY ./build/libs/url-shortener-0.0.1.jar /usr/app

EXPOSE 8080

CMD ./start.sh


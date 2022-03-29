FROM gradle:7.4.1-jdk11 AS build

WORKDIR /serviceA

COPY *.gradle ./
COPY app/ app/
COPY gradle/ gradle/
COPY gradlew gradlew

RUN ./gradlew build

FROM openjdk:11 as runtime

WORKDIR /serviceA

COPY --from=build /serviceA/app/build/distributions/app.tar ./
RUN tar -xvf app.tar

WORKDIR /serviceA/app/lib

ENTRYPOINT [ "java", "-cp", "*", "com.serviceA.App" ]

FROM gradle:7.4.1-jdk11 AS build

WORKDIR /serviceB

COPY *.gradle ./
COPY app/ app/
COPY gradle/ gradle/
COPY gradlew gradlew

RUN chmod +x gradlew
RUN ./gradlew build

FROM openjdk:11 as runtime

WORKDIR /serviceB

COPY --from=build /serviceB/app/build/distributions/app.tar ./
RUN tar -xvf app.tar

WORKDIR /serviceB/app/lib

ENTRYPOINT [ "java", "-cp", "*", "com.serviceA.App" ]

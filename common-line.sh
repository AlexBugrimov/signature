#!/bin/bash
# Запуск модуля demo-service с параметрами
./mvnw -pl demo-service spring-boot:run -Dspring-boot.run.arguments=--demo.signature.username=Ivan

# Запуск из environments variables
DEMO_SIGNATURE_USERNAME=Den ./mvnw -pl demo-service spring-boot:run
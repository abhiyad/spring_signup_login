# Spring Boot Postgress Example
A simple implementaion of Database storing and retrieval using Spring framework.

#Steps to run:
<h3>Install Java 1.8</h3>
```
sudo apt update && sudo apt install openjdk-8-jdk
``` 
<h3>Install and Configure Postgres-SQL</h3>
```
sudo apt update && sudo apt install postgresql postgresql-contrib
```
```
Now you need to make a user in PSQL and a database name
Edit the file application.properties in src/main/resources for $USER, $PASSWORD and $DATABSE-NAME
```
<h3>Install Maven</h3>
```
sudo apt update && sudo apt install maven 
```
<h3>Run in the directory of pom.xml</h3>
```
mvn spring-boot:run
```



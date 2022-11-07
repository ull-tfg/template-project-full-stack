# Back-end

<!-- TOC depthfrom:2 -->

- [Back-end](#back-end)
  - [Description](#description)
  - [How to use](#how-to-use)
    - [Compilation](#compilation)
    - [Run from source code](#run-from-source-code)
    - [Run from JAR](#run-from-jar)
  - [Links](#links)

<!-- /TOC -->

## Description

DESCRIPTION OF BACK-END

## How to use

### Compilation

The back-end can be compiled as follows:
```sh
mvn clean package
```
The resulting JAR, `turnaround-0.0.1-SNAPSHOT.jar`, will be available in `target` folder.

### Run from source code

The back-end can be executed as follows:
```sh
mvn spring-boot:run
```

### Run from JAR

If the JAR is created (as indicated [here](#compilation)), the back-end can be executed as follows:
```sh
java -jar target/turnaround-0.0.1-SNAPSHOT.jar 
```

## Links

LINKS USED IN THE COMPONENT
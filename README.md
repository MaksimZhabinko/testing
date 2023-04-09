Testing

## How to use
#### First step
```
mvn clean install
```
#### Second step
#### Console
```
java -jar target/testing-1.0-SNAPSHOT-jar-with-dependencies.jar 
```
#### File
```
java -jar target/testing-1.0-SNAPSHOT-jar-with-dependencies.jar -enableFileMode='true' -inputTemplate='src/main/resources/test.txt' -outputFile='src/main/resources/testOutput.txt'
```
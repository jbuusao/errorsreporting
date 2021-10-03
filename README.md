# Errors Reporting

Demo project that shows how to record errors and reports on them by grouping by errors, with count of duplicated errors and start and end dates for all errors

## Usage
Build the project
```
mvn clean install -DskipTests
```
Start the application
```
java -jar target\errors-reporting-0.0.1-SNAPSHOT.jar
```
Verify the database via the browser
```
http://localhost:8080/h2
```
Connect to the database (h2, no password), and run the sql query:
```
 select distinct converter from errors;
 select source, context, message, min(date) as begin, max(date) as end, count (*) as count  from errors where converter='TMFIN' group by converter, context, source, message order by min(date);
 select source, context, message, min(date) as begin, max(date) as end, count (*) as count  from errors where converter='TMFOUT' group by converter, context, source, message order by min(date);
 select converter, source, context, message, date from errors where converter='TMFOUT';
```




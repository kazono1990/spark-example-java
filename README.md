# spark-example-java

## Requirements
* Spark 3.1.2
* Java 11
* Scala 2.12
* Maven

## Build
```bash
$ mvn clean package
```

## Submit job to Spark cluster
```bash
$ spark-submit \
  --master spark://localhost:7077 \
  --class jp.co.kazono.spark.example.remote.SparkPi \
  PATH/TO/JAR/FILE.jar \
  1000000
```

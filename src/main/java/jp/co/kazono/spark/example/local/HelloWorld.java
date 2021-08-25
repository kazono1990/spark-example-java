package jp.co.kazono.spark.example.local;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        // You need to set master=local to run local mode
        JavaSparkContext sc = new JavaSparkContext("local", "Hello World");
        JavaRDD<String> rdd = sc.parallelize(Arrays.asList("Hello", "World", "!"));
        rdd.foreach(word -> System.out.print(word + " "));
    }
}

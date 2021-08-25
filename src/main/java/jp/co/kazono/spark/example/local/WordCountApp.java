package jp.co.kazono.spark.example.local;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class WordCountApp {
    public static void run() {
        // use setter to set configs
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("WordCount");

        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> textFile = sc.textFile("src/main/resources/sample.txt");
        JavaPairRDD<String, Integer> counts = textFile
            .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
            .mapToPair(word -> new Tuple2<>(word, 1))
            .reduceByKey((a, b) -> a + b);
        counts.foreach(data -> System.out.println(data._1() + " : " + data._2()));
    }
    public static void main(String[] args) {
        WordCountApp.run();
    }
}

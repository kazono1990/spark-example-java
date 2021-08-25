package jp.co.kazono.spark.example.remote;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.List;

public class SparkPi {

    private static String APP_NAME = "Spark Pi";

    public static void run(int NUM_SAMPLES) {
        List<Integer> list = new ArrayList<>(NUM_SAMPLES);
        for (int i = 0; i < NUM_SAMPLES; i++) {
            list.add(i);
        }

        // remove setMaster for remote deploy
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName(APP_NAME);

        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        long count = sc.parallelize(list)
            .filter(i -> {
                double x = Math.random();
                double y = Math.random();
                return x*x + y*y < 1;
            }).count();

        System.out.println("Pi is roughly " + 4.0 * count / NUM_SAMPLES);
    }

    public static void main(String[] args) {
        SparkPi.run(Integer.parseInt(args[0]));
    }
}

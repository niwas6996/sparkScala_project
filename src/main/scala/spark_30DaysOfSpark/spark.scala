package spark_30DaysOfSpark

import org.apache.spark.sql.SparkSession

trait spark {

  val spark = SparkSession.builder().master("local").getOrCreate()

}
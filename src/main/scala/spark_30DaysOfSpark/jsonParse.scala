package spark_30DaysOfSpark

import org.apache.spark.sql.functions.max
import org.apache.spark.sql.functions.{arrays_zip, explode}
import suresh_scala.spark

object jsonParse extends App with spark {
  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  //reading json data using sparkSession
  val jsondata = spark.read.option("multiline", true)
    .json("C:\\Users\\Hemas\\IdeaProjects\\sparkScala_project\\src\\resources\\input\\test.json")
    .withColumn("NUMBERS", explode(arrays_zip($"PHONE_TYPE", $"NUMBERS"))) //array_zip will map values based on index
    .select("id", "NUMBERS")

  val result = jsondata.select("id", "NUMBERS.*")
    .groupBy($"id").pivot($"PHONE_TYPE")
    .agg(max($"NUMBERS")).orderBy($"id")

  result.show()


}

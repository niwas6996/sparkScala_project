package suresh_scala

import org.apache.spark.sql.functions.{split,explode}

object lega extends App with spark {
  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val input = spark.read.option("delimiter", "|").csv("input.txt").toDF("colm")
    .withColumn("colm",split($"colm"," ").getItem(0))
//    .show(false)





}

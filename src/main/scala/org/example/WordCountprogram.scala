package org.example

import org.apache.spark.rdd.RDD._
import org.apache.spark.sql.SparkSession

object WordCountprogram {
  def main(args:Array[String]): Unit ={

  val spark = SparkSession.builder().master("local[1]").appName("WordCountExample").getOrCreate()

    val inputRdd = spark.sparkContext
      .textFile("wordCount.txt")



    val inputSplitRdd = inputRdd.flatMap(line => line.split(" "))
      .map(word => (word,1))

    val inputSplitRdd1 = inputSplitRdd.reduceByKey((a,b) => a+b)

    inputSplitRdd1.foreach(println)
    inputSplitRdd.foreach(println)

  }

}

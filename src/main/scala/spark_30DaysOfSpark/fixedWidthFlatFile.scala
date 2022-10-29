package spark_30DaysOfSpark


import spark_30DaysOfSpark.spark

object fixedWidthFlatFile extends App with spark {
  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val flatFileDf = spark.read.textFile("fixedWidthFlatFile")
  val trimDf = flatFileDf.withColumn("id",$"value".substr(0,2))
    .withColumn("product",$"value".substr(3,10))
    .withColumn("T/F",$"value".substr(13,6))
    .withColumn("qty",$"value".substr(19,5))

  flatFileDf.show(false)
//  trimDf.show(false)



}

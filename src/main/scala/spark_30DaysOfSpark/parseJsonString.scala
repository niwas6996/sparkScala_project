package spark_30DaysOfSpark

object parseJsonString extends App with spark {
  import spark.implicits._
  spark.sparkContext.setLogLevel("ERROR")
  val rdd = spark.sparkContext.parallelize("""{"Zipcode":704,"ZipCodeType":"STANDARD","City":"PARC PARQUE","State":"PR"}""")




}

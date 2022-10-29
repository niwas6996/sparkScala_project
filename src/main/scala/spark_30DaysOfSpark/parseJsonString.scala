package spark_30DaysOfSpark

import org.apache.spark.sql.Encoders
import org.apache.spark.sql.functions.from_json

object parseJsonString extends App with spark {

  import spark.implicits._

  spark.sparkContext.setLogLevel("ERROR")
  val data = Seq("""{"Zipcode":704,"ZipCodeType":"STANDARD","City":"PARC PARQUE","State":"PR"}""")
  val jsonString = """{"Zipcode":704,"ZipCodeType":"STANDARD","City":"PARC PARQUE","State":"PR"}"""
  val jsonStringRDD = spark.sparkContext
    .parallelize("""{"Zipcode":704,"ZipCodeType":"STANDARD","City":"PARC PARQUE","State":"PR"}""" :: Nil)
  val jsonDs = spark.read.json(Seq(jsonString).toDS()).show()
  val jsonDf = spark.read.json(jsonStringRDD).show()

//  case class JsonSchema(Zipcode: Int, ZipCodeType: String, City: String, State: String)
//
//  val schema = Encoders.product[JsonSchema].schema
//
//  val df = data.toDF("value")
//    .withColumn("value", from_json($"value", schema))
//    .select("value.*")

//    .show(false)


}

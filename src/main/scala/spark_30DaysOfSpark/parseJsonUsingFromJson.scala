package spark_30DaysOfSpark

import org.apache.spark.sql.Encoders
import org.apache.spark.sql.functions.{from_json, struct, to_json}
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}
import spark_30DaysOfSpark.JsonSchema.JsonSchema


object parseJsonUsingFromJson extends App with spark {
  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val inputJson = spark.read.options(Map("header" -> "true", "delimiter" -> "|"))
    .csv("fromJson.csv")

  val schema = new StructType().add("Zipcode", IntegerType)
    .add("ZipCodeType", StringType)
    .add("City", StringType)
    .add("State", StringType)
//  case class JsonSchema(Zipcode:Int,ZipCodeType:String,City:String,State:String)



  val metadata = Encoders.product[JsonSchema].schema

  val parseJsonCol = inputJson.withColumn("structJson", from_json($"JsonValue", metadata))

  val flatJson = parseJsonCol.select("id", "structJson.*")


  // to_JSON

  val DftoJson = flatJson.select($"id",
    to_json(struct("Zipcode", "ZipCodeType", "City", "State").as("")).as("JsonValue"))

  val withoutSchema = inputJson.withColumn("new",struct($"JsonValue")).select("new.*").show(false)

  DftoJson.show(false)
  flatJson.show(false)

  //  parseJsonCol.show(false)
  //  parseJsonCol.printSchema()
  schema.printTreeString()
}

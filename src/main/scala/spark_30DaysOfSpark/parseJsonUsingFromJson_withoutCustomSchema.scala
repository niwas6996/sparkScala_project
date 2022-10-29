//package spark_30DaysOfSpark
//
//import org.apache.spark.sql.functions.from_json
//import org.apache.spark.sql.types.StructType
//
//
//object parseJsonUsingFromJson_withoutCustomSchema extends App with spark {
//
//  import spark.implicits._
//
//  val inputJson = spark.read.options(Map("delimiter" -> "|", "header" -> "true")).csv("fromJson.csv")
////  val filterJson = inputJson.select($"JsonValue").collect()(0).getString(0)
////
////  val ddlSchema = spark.sql(s"select schema_of_json('${filterJson}')")
////                              .collect()(0)
////                              .getString(0)
////                              .replace("null", "string")
////  val schema = StructType.fromDDL(s"js_schema $ddlSchema")
////  schema.printTreeString()
////
////  val parseJson = inputJson.withColumn("js_schema", from_json($"JsonValue", schema)).show(false)
//
//  //  val schema = spark.read.json(df.rdd.map(l=>l.JsonValue)).schema
//
//  val filterDf = inputJson.select($"JsonValue")
//  val schema = spark.read.json(filterDf.toDS)
//
//}

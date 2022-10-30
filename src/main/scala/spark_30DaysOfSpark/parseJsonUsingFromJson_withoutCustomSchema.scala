package spark_30DaysOfSpark

import org.apache.spark.sql.types.{DataType, StructType}

import scala.io.Source

object parseJsonUsingFromJson_withoutCustomSchema extends App with spark {

  import spark.implicits._


  val url = ClassLoader.getSystemResource("schema.json")
  val schemaSource = Source.fromFile(url.getFile).getLines.mkString
  val schemaFromJson = DataType.fromJson(schemaSource).asInstanceOf[StructType]
  val df2 = spark.read.schema(schemaFromJson )
    .json("fromJson.csv")
  df2.printSchema()
  df2.show(false)





  //  val jsonFile = spark.sparkContext.textFile("fromJson.csv")
//  val jsonFile = spark.read.options(Map("multiline"->"true","delimiter"->"|","header"->"true"))
//    .csv("fromJson.csv")
//    .drop("id")
//    .map(line=>"\"\"\""+line+"\"\"\"")

//  def jsonparse (i:org.apache.spark.sql.Column)=


//    for(i<- jsonFile){

//      val rdd = spark.sparkContext.parallelize(i::Nil)
//      val jsonString = spark.read.json(rdd)

//    }








//  val firstLine = jsonFile.first()
//  val jsonData= jsonFile.filter(head=>head!=firstLine)

//    .map(line=>"\"\"\""+line+"\"\"\"")

//  for(i<-jsonData){
//    var jsonDf = spark.read.
//
//  }

//  val jsonDf = spark.read.json(jsonData).show()

//  val inputJson = spark.read.options(Map("delimiter" -> "|", "header" -> "true")).csv("fromJson.csv")
//  val filterJson = inputJson.select($"JsonValue").collect()(0).getString(0)
//
//  val ddlSchema = spark.sql(s"select schema_of_json('${filterJson}')")
//                              .collect()(0)
//                              .getString(0)
//                              .replace("null", "string")
//  val schema = StructType.fromDDL(s"js_schema $ddlSchema")
//  schema.printTreeString()
//
//  val parseJson = inputJson.withColumn("js_schema", from_json($"JsonValue", schema)).show(false)

  //  val schema = spark.read.json(df.rdd.map(l=>l.JsonValue)).schema

//  val filterDf = inputJson.select($"JsonValue")
//  val schema = spark.read.json(filterDf.toDS)

}

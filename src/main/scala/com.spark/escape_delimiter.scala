import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{IntegerType, StringType, StructType}
import org.apache.spark.sql.functions._

object escape_delimiter extends App {

  val spark = SparkSession.builder().master("local").getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  import spark.implicits._
  val schema = new StructType().add("id", StringType).add("col",StringType).add("value",StringType)
  val input = spark.read.schema(schema).option("multiLine",true)
    .csv("C:\\Users\\Hemas\\OneDrive\\Desktop\\str_agg.csv").show(false)
//  val splitDF = input.withColumn("data",split($"data",","))
//    .withColumn("id",slice($"data",1,1))
//    .withColumn("col",slice($"data",2,1))
//    .withColumn("value",slice($"data",3,6)).drop("data")
//  val stringDF =splitDF.withColumn("id",concat_ws(",",$"id"))
//    .withColumn("col",concat_ws(",",$"col"))
//    .withColumn("value",concat_ws(",",$"value"))
//    .createTempView("tmp")

//  spark.sql(""" select id,group_concat(value) from tmp group by id  """).show(false)

//
//  val groupedDF = stringDF.groupBy("id")
//    .agg(concat_ws(",",collect_list($"value")).as("value"))
//    .show(false)

}

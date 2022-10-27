import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object jsonTupleExpl {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val inputData = spark.read.options(Map("header" -> "true", "escape" -> "\"", "delimiter" -> ","))
      .csv("C:\\Users\\Hemas\\IdeaProjects\\spark-etl1\\src\\main\\scala\\Json_tuple")

    inputData.show(false)
    inputData.printSchema()

    // val jsonTuple=inputData.select("*",json_tuple(col("request"),col("Response")))

  }
}
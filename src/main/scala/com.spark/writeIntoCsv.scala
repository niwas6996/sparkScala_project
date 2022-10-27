import org.apache.spark.sql.{SaveMode, SparkSession}
import org.apache.spark.sql.functions.{col, lit}

object writeIntoCsv {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local").getOrCreate()
    System.setProperty("hadoop.home.dir", "C:\\winutils")
    spark.sparkContext.setLogLevel("error")
    val inputDF=spark.read.format("csv").option("header",true).option("inferSchema",true)
      .load("C:\\Users\\Hemas\\Downloads\\MOCK_DATA (1).csv")
    //inputDF.printSchema()
   // inputDF.show(false)
    import spark.implicits._
    //val filterDF=inputDF.coalesce(col("last_name"),lit("NA"))
    inputDF.write.format("csv").option("header",true).option("inferSchema",true)//.mode(SaveMode.Overwrite)
      .save("C:\\Users\\Hemas\\Downloads\\output3")

  }

}

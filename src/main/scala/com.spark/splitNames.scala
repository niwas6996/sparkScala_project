import org.apache.spark.sql.SparkSession

object splitNames {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local").getOrCreate()
    System.setProperty("hadoop.home.dir", "C:\\winutils")
    spark.sparkContext.setLogLevel("error")
    val inputDF=spark.read.option("header",true).option("inferSchema",true)
      .csv("")
    //val outputDF=inputDF.withColumn("f_name",)
    inputDF.show()
  }

}

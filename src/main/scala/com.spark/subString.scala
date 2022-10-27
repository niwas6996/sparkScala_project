import org.apache.spark.sql.SparkSession



//object subString {
//  def main(args: Array[String]): Unit = {
//    val spark: SparkSession = SparkSession.builder().master("local[1]")
//      .appName("sparkByExamples.com")
//      .getOrCreate()
//    val inputDF=spark.read.text("C:\\Users\\Hemas\\OneDrive\\Desktop\\substring.txt")
//    inputDF.show()
//
//    inputDF.select(inputDF("value").substring(1,3).alias("id"), inputDF.value.substring(4,8)
//                  .alias("date")
//                   ,inputDF.value.substring(12, 3).alias("string")
//                   ,inputDF.value.substring(15, 4).cast("integer").alias("integer")).show()
//
//  }
//}*/
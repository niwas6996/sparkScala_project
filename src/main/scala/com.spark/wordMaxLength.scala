import org.apache.spark.sql.SparkSession

object wordMaxLength {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().master("local[1]")
      .appName("word having max length")
      .getOrCreate()
    val inputRDD=spark.sparkContext.textFile("C:\\Users\\Hemas\\IdeaProjects\\spark-etl1\\src\\main\\scala\\textFile.text")
    val resultRDD= inputRDD.flatMap(line=>line.split(" ")).map(word=>word.length())


  }
}
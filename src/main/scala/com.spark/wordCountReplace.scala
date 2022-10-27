import org.apache.commons.lang.StringUtils.replace
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.lower

object wordCountReplace {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local").getOrCreate()
    val inputRDD=spark.sparkContext.textFile("C:\\Users\\Hemas\\IdeaProjects\\spark-etl1\\src\\main\\scala\\word_count_replace")
    val finalRDD=inputRDD.flatMap(line=>line.split(" "))
      .map(word=>replace(word,".",""))
      .map(word=>(word,1))
      .reduceByKey((a,b)=>a+b)
    finalRDD.foreach(println)
  }


}

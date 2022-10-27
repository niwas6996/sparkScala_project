import org.apache.spark.sql.SparkSession

object Wordcount {
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local[1]").appName("wordCount").getOrCreate()

    val inputRDD=spark.sparkContext
      .textFile("C:\\Users\\Hemas\\OneDrive\\Documents\\wordcountdoc.txt")
//    val filterRDD=inputRDD.flatMap(line=>line.split(" ")).map(word=>(word,1))
//    val resultRDD=filterRDD.reduceByKey(_+_)
//    resultRDD.foreach(println)

    inputRDD.flatMap(x=>x.split(" ")).filter(v=>v=="world")
      .map(x=>(x,1))
      .reduceByKey(_+_)

      .foreach(println)



  }


}

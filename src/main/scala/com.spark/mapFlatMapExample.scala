import org.apache.spark.sql.types.{ArrayType, StringType, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object mapFlatMapExample {
  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate()
    spark.sparkContext.setLogLevel("error")

    val data = Seq("Project Gutenberg’s",
      "Alice’s Adventures in Wonderland",
      "Project Gutenberg’s",
      "Adventures in Wonderland",
      "Project Gutenberg’s")

    import spark.sqlContext.implicits._
    val df = data.toDF("data")
    df.show(false)

    //Map Transformation
    val mapDF=df.map(fun=> {
      fun.getString(0).split(" ")
    })
    mapDF.show(false)

    //Flat Map Transformation
    val flatMapDF=df.flatMap(fun=>
    {
      fun.getString(0).split(" ")
    })
    flatMapDF.show()




  }


}

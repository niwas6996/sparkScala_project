import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

object SelectSelectExpr {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local[1]")
      .appName("SparkByExamples.com")
      .getOrCreate()
     spark.sparkContext.setLogLevel("error")
//    val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))
//    val df = spark.createDataFrame(data).toDF("language","users_count")
//    df.select("language","users_count as count").show() //Example 1
//    df.select(df("language"),df("users_count").as("count")).show() //Example 2
//    df.select(col("language"),col("users_count")).show() ////Example 3
//    //df.select("language",col("users_count")).show() ////Example 3
//
//    df.selectExpr("language","users_count as count").show() //Example 1
//    //df.selectExpr(df("language"),df("users_count").as("count")).show() //Example 2
//    //df.selectExpr(col("language"),col("users_count")).show() ////Example 3

    import spark.implicits._

    val simpleData = Seq(("James","Sales","NY",90000,34,10000),
      ("Michael","Sales","NY",86000,56,20000),
      ("Robert","Sales","CA",81000,30,23000),
      ("Maria","Finance","CA",90000,24,23000),
      ("Raman","Finance","CA",99000,40,24000),
      ("Scott","Finance","NY",83000,36,19000),
      ("Jen","Finance","NY",79000,53,15000),
      ("Jeff","Marketing","CA",80000,25,18000),
      ("Kumar","Marketing","NY",91000,50,21000)
    )
    val df = simpleData.toDF("employee_name","department","state","salary","age","bonus")
      println( df.rdd.getNumPartitions)
    val df2 = df.groupBy("state").count()
    df2.show(false)
    println(df2.rdd.getNumPartitions)

  }

}

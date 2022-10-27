import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object HP_test extends App {

  val spark = SparkSession.builder()
    .master("local[2]")
    .appName("HP_Json_driver")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  import spark.implicits._

  val filePath = "C:\\Users\\Hemas\\Downloads\\json.json"
  val readJsonDF = spark.read.option("multiline",true).json(filePath)
  val countDf = readJsonDF
    .withColumn("games_played",size(split(col("rankings"),",")))
    .createTempView("games")
  println("1.List of participants who has participated the maximum number of times.")
  val first_ques = spark.sql(
    """select * from games where games_played =
      |(select max(games_played) from games)""".stripMargin)
  first_ques.show()

println("2.List of participants who won Rank 1 most of the times.")

//  val sum_arr =
def addValue = udf((array:Seq[Int])=>array++array)

  val filterColumnDF = readJsonDF
                        .withColumn("array_col",split($"rankings",","))
    .withColumn("games_played",size(split(col("rankings"),",")))
    .withColumn("explode",explode($"array_col"))
    .groupBy("address", "alphanumeric", "email", "name", "phone", "postalZip", "rankings","games_played")
    .agg(round(sum($"explode")/$"games_played",2).as("avg_of_rankings")).createTempView("tem")
  spark.sql(
    """select * from tem where avg_of_rankings =
      |(select min(avg_of_rankings) from tem)
      |""".stripMargin).show()
//    .withColumn("sum",addValue($"array_col".cast("array<int>"))).show(false)
//    .createTempView("temp2")
//      spark.sql(""" select collect_list(cast(array_col as int)) from temp2 """).show()
//    .withColumn("addValue",addValue($"array_col")).show()
//    .withColumn("new",aggregate($"array_col",lit(0),(x,y)=>x+y)).show()
//                        .withColumn("sum_array",aggregate(col("array_col"),lit(0),(x,y)=>x+y)).show()
//    .withColumn("sum_array",sumOfArray($"array_col"))
//  val sec_ques = filterColumnDF
////    .filter(array_contains($"array_col","1"))
//    .groupBy($"name").agg(count($"rankings").as("num_golds"))
//  sec_ques.show()

  println("3.The country with maximum participants.")
  val third_ques = spark.sql(
    """with temp as (select alphanumeric,count(name) as num_participants
      |from games group by alphanumeric)
      | select alphanumeric,max(num_participants) from temp group by alphanumeric """.stripMargin).show()
//  third_ques.show()
//  readJsonDF.write.mode("overWrite").option("header",true)
//    .format("csv").save("C:\\Users\\Hemas\\OneDrive\\Desktop\\JSON_HP")


  println("4.The country whose participants had highest average ranking.")
  val df = readJsonDF.withColumn("array_col",split($"rankings",",")).show()
//    df.filter(array_contains($"array_col",'')).show()
//  val fourDF = readJsonDF.withColumn("array_rankings",explode()).groupBy($"name").agg(sum($"rankings")).show()
//  val fourDf = readJsonDF.withColumn("array_rankings",split($"rankings",","))
//    .createTempView("temp")
//  val fourdf2 = fourDf.withColumn("sum_array",expr("aggregate(array_rankings,lit(0),(x,y) -> x+y"))
//  val dourDF2 = fourDf.withColumn("sum_rankings",(explode_outer($"array_rankings")))
//  spark.sql(""" select *, aggregate(array_rankings,0,(x,y)-> x+y) from temp """).show()




}

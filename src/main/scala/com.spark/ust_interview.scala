import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{datediff, lag, row_number, udf}

object ust_interview extends App {

  val spark = SparkSession.builder.master("local").getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val input = spark.read.option("header", true).option("inferSchema", true).csv("C:\\Users\\Hemas\\Downloads\\ust_data.txt")

    //  val resDF = input.withColumn("rank",row_number().over(Window.partitionBy($"id").orderBy($"admin_date".desc)))
    //    .filter("rank==1")

  val addFive = (x:Int)=> x + 5
  val adFive=udf(addFive)

  val WindowSpec = Window.partitionBy($"id").orderBy($"admin_date".desc)
  val lagDF = input.withColumn("lag",datediff(lag("admin_date",1).over(WindowSpec),$"admin_date"))
    .withColumn("new",adFive($"lag")).show()
//  spark.sql("""select * from emp join dep on emp.id=dep.id join   """).show()
//  scala.io.StdIn.readLine()

}

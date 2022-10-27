import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object covid_vacination_Cognizant_interview extends App {

  val spark = SparkSession.builder().master("local").getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  import spark.implicits._
  val inpudDF = spark.read.option("header",true).option("inferSchema",true)
    .csv("C:\\Users\\Hemas\\Downloads\\covid.csv")
//    .filter($"second_dose"==="yes")
  inpudDF.groupBy("state").agg(count("second_dose").as("vac_completed")).show()

}

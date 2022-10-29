import org.apache.spark.sql.functions.explode_outer
import org.apache.spark.sql.{SparkSession, functions}

object AWS extends App{

  val spark = SparkSession.builder().getOrCreate()
  import spark.implicits._
  val jsonData = spark.read.option("multiline",true)
    .json("C:\\Users\\Hemas\\Downloads\\json.json")

  jsonData.withColumn("rankings",explode_outer(functions.split($"rankings",",")))
    .show()

}

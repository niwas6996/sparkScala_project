import org.apache.spark.sql.SparkSession

object Schema_with_caseClass extends App{
  case class col(id:Integer,value:String,value_2:String)

  val spark = SparkSession.builder().master("local").getOrCreate()
  import spark.implicits._
val schema= Seq[col]().toDF().schema
  val input = spark.read
    .schema(schema)
    .csv("C:\\Users\\Hemas\\OneDrive\\Desktop\\ORDER.CSV")
  input.show()
  input.printSchema()

}

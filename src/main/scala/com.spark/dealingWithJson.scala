import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object dealingWithJson {

//  case class schema(emp_id:Int,emp_name:String,dept:String,salary:Int)
  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val columns=Seq("emp_id","emp_name","dept","salary")
    val schema=new StructType()
      .add("emp_id",IntegerType,true)
      .add("emp_name",StringType,true)
      .add("dept",StringType,true)
      .add("salary",IntegerType,true)
    import spark.implicits._

    val inputDf=spark.sparkContext.parallelize(Seq((1,"Hema","Mathematics",80000),
      (2,"Anu","Botany",45000),
      (3,"Venu","Computers",40000),
      (4,"Swetcha","Physics",30000),
      (5,"Jai","Chemistry",70000))).toDF(columns:_*)

    inputDf.show(false)

    val toJsonDf=inputDf.toJSON
    toJsonDf.printSchema()
    toJsonDf.show(false)

    val fromJsonDf=toJsonDf.withColumn("record",from_json(col("value"),schema))
      .drop("value")
    fromJsonDf.printSchema()
    fromJsonDf.show(false)

    val JsonConversion=fromJsonDf.select("*","record.*").drop("record")
    JsonConversion.show(false)
    JsonConversion.printSchema()


  }

}

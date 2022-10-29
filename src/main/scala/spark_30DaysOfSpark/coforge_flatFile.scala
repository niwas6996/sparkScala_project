package spark_30DaysOfSpark

import org.apache.spark.sql.functions._
import org.apache.spark.sql.Encoders

object coforge_flatFile extends App with spark {
  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  case class cols(emp_no: Int, emp_name: String, emp_tel_no: Long)

  val schema = Encoders.product[cols].schema

  val txtFile = spark.sparkContext.textFile("coforge_flatFile.txt")
  val header = txtFile.first()
  val data = txtFile.filter(head => head != header)
  val df = data.toDF("value")
  val addCol = df.withColumn("emp_no",split($"value",",").getItem(0))
    .withColumn("emp_name",split($"value",",").getItem(1))
    .withColumn("emp_tel_no",split($"value",",").getItem(2))
    .select("emp_no","emp_name","emp_tel_no")
    .show()
//    .printSchema()
  //  val header = txtFile.take(1)
  //    .flatMap(f => f.split(",")).mkString(",")
  //  val firstRow = txtFile.first()
  //  val data = txtFile.filter(head => head != firstRow)
  //  val df = data.toDF(header)


  //  val finaldf = data.toDF(schema)

  //    println(header)
  //    .foreach(println)

}




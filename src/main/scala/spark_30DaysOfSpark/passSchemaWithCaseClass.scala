package spark_30DaysOfSpark

import org.apache.spark.sql.Encoders

object passSchemaWithCaseClass extends App with spark{
  import spark.implicits._
  spark.sparkContext.setLogLevel("ERROR")

  case class cols(id:Int,name:String,salary:String)
  val schema = Encoders.product[cols].schema
  val data= Seq(cols(1,"suresh","20000"),cols(2,"satish","25000"))
//  val data2= Seq((1,"suresh",20000),(2,"satish",25000))

  data.toDF().as[cols].printSchema()


}

package spark_30DaysOfSpark

object createDataSet extends App with spark{
  import spark.implicits._
  spark.sparkContext.setLogLevel("ERROR")

  case class cols(id:Int,name:String)
  val data = Seq((1,"suresh"),(2,"hannu"),(3,"ammu"))
  val df = data.toDF("Id","Name")
  val ds = df.as[(Int,String)]
  ds.show()

  val dataSet = Seq(cols(1,"suresh"),cols(2,"hannu"),cols(3,"ammu")).toDS()
  dataSet.show()







}

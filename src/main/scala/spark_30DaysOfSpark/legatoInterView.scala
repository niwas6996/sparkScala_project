package spark_30DaysOfSpark

object legatoInterView extends App with spark{

import spark.implicits._
  spark.sparkContext.setLogLevel("ERROR")
  val inputCsvData = spark.read.options(Map("inferSchema"->"true","delimiter"->"|"))
    .csv("legatoInterViewData.csv").toDF("Movie","Gener")
    .filter("Gener like '%Action%'").createTempView("temp")

    spark.sql("""select count(*) from temp""").show(false)


}

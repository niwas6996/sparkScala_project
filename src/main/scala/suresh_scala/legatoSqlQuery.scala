package suresh_scala

import org.apache.spark.sql.SparkSession

object legatoSqlQuery extends App {

  val spark=SparkSession.builder().master("local[1]").getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  val sr="C:\\Users\\Hemas\\Downloads\\m.csv.csv"
  val df=spark.read.option("header",true).option("inferSchema",true).csv(sr)
df.show()
  df.createOrReplaceTempView("tab")


  spark.sql(
    """select * from tab where plan = 'VSN' and id in
      | (select id from tab group by id having count(distinct plan)=1)
      |""".stripMargin).show()


}
package spark_30DaysOfSpark

object baskar_interview extends App with spark{
  spark.sparkContext.setLogLevel("ERROR")

val inputDf = spark.read.options(Map("header"->"true","inferSchema"->"true"))
  .csv("baskar_interView.csv").createTempView("temp")

  spark.sql(
    """with cte as  (select *,sales-lag(sales,1,0) over(partition by product order by year) sales_diff
      |from temp)
      |select * from cte where product not in (select product from cte where sales_diff like '-%') """.stripMargin).show()

  spark.sql("""select product from temp group by 1 having count(*)=(select count(distinct year) from temp)""").show()


}

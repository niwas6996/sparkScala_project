package spark_30DaysOfSpark

import org.apache.spark.sql.DataFrame

object tech21Interview extends App with spark {

  import spark.implicits._

  spark.sparkContext.setLogLevel("ERROR")
  val data1 = Seq(("Table-1", 12), ("Table-2", 15), ("Table-3", 18))
  val data2 = Seq(("Table-1", 12), ("Table-6", 15), ("Table-3", 10))

  val cols = Seq("tableName", "rowCount")

  val dataset_1 = data1.toDF(cols: _*)
  val dataset_2 = data2.toDF(cols: _*)

  //creating method to join dataframes with filter condition
  def filterCondition(x:String,y:String,f:(String,String)=>String)=f(x,y)
  def dataDiff(df1: DataFrame, df2: DataFrame, commonCol: String, joinType: String, filterCondition: scala.Predef.String) =
//  def dataDiff(df1: DataFrame, df2: DataFrame, commonCol: String,
//               joinType: String, filterCondition: ) =

    df1.join(df2, Seq(commonCol), joinType).filter(filterCondition)

  val resultDf = dataDiff(dataset_1, dataset_2, "rowCount", "fullouter", "rowCount != rowCount")

  resultDf.show()





  //
  //  dataset_1.show()
  //  dataset_2.show()
  //
  //  dataset_1.createTempView("dataset1")
  //  dataset_2.createTempView("dataset2")
  //
  //  val joindf = dataset_1.join(dataset_2, Seq("tableName"), "full")
  //    .toDF("tableName", "Ds1_rowCount", "Ds2_rowCount")
  //
  //    joindf.createTempView("temp")
  ////  joindf.show()
  //
  //  spark.sql(
  //    """with cte as (select *,case when Ds1_rowCount is null then 0 else Ds1_rowCount end as Ds1,
  //      |case when Ds2_rowCount is null then 0 else Ds2_rowCount end as Ds2
  //      | from temp)
  //      | select tableName,Ds1_rowCount,Ds2_rowCount from cte where Ds1<>Ds2 order by 1
  //      | """.stripMargin)
  ////    .show()
  //
  ////  spark.sql(
  ////    """with cte as
  ////      |   (select * from dataset1 d1 union all select * from dataset2 d2)
  ////      |select t.tableName,t.rowCount from
  ////      |(select *,lag(tableName) over(order by tableName) tN,lag(rowCount) over(partition by tableName order by rowCount) rC from cte) t
  ////      |where t.tablename<>t.tN and t.rowCount<>t.rC
  ////      |""".stripMargin)
  ////    .show()
  //
  //  spark.sql(
  //    """with cte as  (select coalesce(d1.tableName,d2.tableName) tableName,
  //      |d1.rowCount DS_1RowCount,d2.rowCount DS_2RowCount from dataset1 d1 full join dataset2 d2 on
  //      |d1.tableName=d2.tableName)
  //      |select * from cte where tableName not in (select tableName from cte where DS_1RowCount= DS_2RowCount)
  //      |order by 1 """.stripMargin)
  //    .show()
  ////  spark.sql("""select * from dataset1 d1 union select * from dataset2 d2""").show()

}

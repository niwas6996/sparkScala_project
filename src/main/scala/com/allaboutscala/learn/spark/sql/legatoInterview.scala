package com.allaboutscala.learn.spark.sql

import suresh_scala.spark

object legatoInterview extends App with spark {

  import spark.implicits._
  spark.sparkContext.setLogLevel("ERROR")

  val data1 = Seq(("Table-1", 12), ("Table-2", 15), ("Table-3", 18))
  val data2 = Seq(("Table-1", 12), ("Table-6", 15), ("Table-3", 10))

  val cols = Seq("tableName", "rowCount")

  val dataset_1 = data1.toDF(cols: _*).createTempView("dataset1")
  val dataset_2 = data2.toDF(cols: _*).createTempView("dataset2")

  spark.sql("""select  from dataset1 d1
              |full outer JOIN
              |dataset2 d2
              |on
              |d1.tableName=d2.tableName
              |and
              |d1.rowCount<>d2.rowCount """.stripMargin).show()

}

package org.example

import org.apache.spark.sql.SparkSession
import org.example.Bulk_alter_Columns.df

object Bulk_alter_Columns extends App {

  val toCamel = (s: String) => {
    val split = s.split("_")
    val head = split.head
    val tail = split.tail.map { x => x.head.toUpper + x.tail }

    head + tail.mkString
  }
  spark.udf.register("toCamel", toCamel)

  val spark = SparkSession.builder.master("local").getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")

  val inputCsv = spark.read.option("header", true)
    .option("delimiter", "|")
    .option("inferSchema", true)
    .csv("C:\\Users\\Hemas\\OneDrive\\Desktop\\bulkRenameCols.csv")
  //  val newCols= inputCsv.columns
  //    .map(m=>m.split("_")).mkString

  val cols = inputCsv.columns

  var df = inputCsv

  for (i <- cols) {
    //    df = df.withColumnRenamed(i,i.replace("_", " "))
    df = df.withColumnRenamed(i, toCamel(i))
  }
  df.show()
  //  inputCsv.toDF(newCols:_*).show()


  //  val df = inputCsv.toDF(c:_*).show()

  //  for(c<- cols){
  //    resultdf = inputCsv.withColumnRenamed(c,)
  //  }


  //  val alterCols = cols.map(x=>x.replace(" ","_"))

  //  val finaldf = inputCsv.select(alterCols.head,alterCols:_*).show()


}

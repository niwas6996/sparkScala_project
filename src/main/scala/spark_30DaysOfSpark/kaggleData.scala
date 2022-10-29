package spark_30DaysOfSpark

import org.apache.spark.sql.functions._

object kaggleData extends App with spark {

  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val csvDf = spark.read.option("header", true).option("inferSchema", true)
    .csv("C:\\Users\\Hemas\\Downloads\\archive\\stockerbot-export.csv")
  val csvData = spark.sparkContext.textFile("C:\\Users\\Hemas\\Downloads\\archive\\stockerbot-export.csv")
    .flatMap(f => f.split(" ")).filter(value => value == "is")
    .map(word => (word, 1))
    .reduceByKey(_ + _)

  csvData.foreach(println)
  csvDf
    //    .withColumn("timestamp",split($"timestamp","\\+").getItem(0))
    //    .withColumn("timestamp",to_timestamp($"timestamp","DDD MMM dd HH:mm:ss"))
    .withColumn("dateDiff", datediff(current_timestamp(), to_timestamp($"timestamp", "EEE MMM dd HH:mm:ss zzz yyyy")))
    .select("id").createTempView("data")
//    .agg(count("id")-countDistinct("id"))
spark.sql("""select * from (select id,dense_rank() over(partition by id order by id) dr from data ) t where t.dr = 2 """)

//    spark.sql("""select id,count(id)-count(distinct id) as duplicate from data group by id order by 2 desc limit 1""")
    .show(truncate = false)
}

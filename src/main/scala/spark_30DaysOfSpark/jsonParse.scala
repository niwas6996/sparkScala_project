package spark_30DaysOfSpark

import org.apache.spark.sql.functions.{arrays_zip, explode, max, when}

object jsonParse extends App with spark {
  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  //reading json data using sparkSession
  val jsondata = spark.read.option("multiline", true)
    .json("C:\\Users\\Hemas\\IdeaProjects\\sparkScala_project\\src\\resources\\input\\test.json")
    val newCol = jsondata
    .withColumn("NUMBERS", explode(arrays_zip($"PHONE_TYPE", $"NUMBERS"))) //array_zip will map values based on index
    .select("id", "NUMBERS")

  val result = newCol.select("id", "NUMBERS.*")
    .groupBy($"id").pivot($"PHONE_TYPE")
    .agg(max($"NUMBERS")).orderBy($"id")

  jsondata.createTempView("json")
//  spark.sql(
//    """ with cte as (select t.id,t.number.* from (select id,explode(arrays_zip(phone_type,numbers)) as number from json) t)
//      | select * from cte pivot(
//      | max(numbers) for phone_type in(M,F,T)
//      | )
//      |
//      |""".stripMargin).show()
  jsondata.repartition(1).write.option("header",true)
    .mode("overWrite").csv("C:\\Users\\Hemas\\OneDrive\\Desktop\\suresh\\json")
//jsondata.show()
//  val usingCaseWhen = jsondata.withColumn("M",when($"PHONE_TYPE"==="M","NUMBERS").otherwise(null))
//    .withColumn("T",when($"PHONE_TYPE"==="T","NUMBERS").otherwise(null))
//    .withColumn("F",when($"PHONE_TYPE"==="F","NUMBERS").otherwise(null))
//val usingCaseWhen = jsondata.select("id", "NUMBERS.*")
//  .groupBy($"id").agg(max(when($"PHONE_TYPE"==="M","NUMBERS").otherwise(null)).as("M"))
//  .agg(max(when($"PHONE_TYPE"==="T","NUMBERS").otherwise(0)).as("T"))
//  .agg(max(when($"PHONE_TYPE"==="F","NUMBERS").otherwise(0)).as("F"))
//  when($"PHONE_TYPE"==="T","NUMBERS").otherwise(null))
//  ,when($"PHONE_TYPE"==="F","NUMBERS").otherwise(null))

//  .show()


}

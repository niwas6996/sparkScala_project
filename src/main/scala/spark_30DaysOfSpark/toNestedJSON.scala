package spark_30DaysOfSpark

import spark_30DaysOfSpark.toNestedJSON_Package._

object toNestedJSON extends App with spark  {

    spark.sparkContext.setLogLevel("ERROR")
    import spark.implicits._
    val inputCSV = spark.read.option("header",true).csv("toNestedJSON.csv")

    val nestedJSON = inputCSV.map( f => {
      val name_n = name(f.getString(1))
      val age_n = age(f.getString(2))
      val loc_n = loc(f.getString(3))
      val details_n = details(name_n,age_n,loc_n)
      val lan1_n =lang1(f.getString(6))
      val lan2_n =lang2(f.getString(7))
      val lan3_n =lang3(f.getString(8))
      val language_n = language(lan1_n,lan2_n,lan3_n)
      val languages_n = languages(Array(language_n))

      record(f.getString(0),details_n,f.getString(4),f.getString(5),languages_n)
    })
  inputCSV.show(false)
  nestedJSON.show(false)
    nestedJSON.printSchema()

  }


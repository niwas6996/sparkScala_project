package itVersity_Retail

import org.apache.spark.sql.SparkSession


object class_2 extends App{

  val spark = SparkSession.builder().master("local").getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  val rdd = Seq((1,2),(1,4),(2,6),(2,8))

  val rdd2 = spark.sparkContext.parallelize(rdd)

  val rdd3 = rdd2.mapValues(x=>(x,1)).reduceByKey((x,y)=>(x._1+y._1,x._2+y._2))

    val avg = rdd3.mapValues(x=>x._1/x._2).collect()



    avg.foreach(println)

}

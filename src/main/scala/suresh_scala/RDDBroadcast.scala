package suresh_scala

import org.apache.spark.sql.SparkSession

object RDDBroadcast extends App {

  val spark = SparkSession.builder()
    .appName("SparkByExamples.com")
    .master("local")
    .getOrCreate()
  import spark.implicits._

  val states = Map(("NY", "New York"), ("CA", "California"), ("FL", "Florida"))
  val countries = Map(("USA", "United States of America"), ("IN", "India"))

  val broadcastStates = spark.sparkContext.broadcast(states)
  val broadcastCountries = spark.sparkContext.broadcast(countries)

  val data = Seq(("James", "Smith", "USA", "CA"),
    ("Michael", "Rose", "USA", "NY"),
    ("Robert", "Williams", "USA", "CA"),
    ("Maria", "Jones", "USA", "FL"))
  val columns = Seq("name","last_name","country","state")

  data.toDF(columns:_*).show()

}
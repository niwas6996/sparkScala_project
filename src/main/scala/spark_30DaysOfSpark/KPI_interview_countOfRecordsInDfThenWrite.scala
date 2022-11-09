package spark_30DaysOfSpark

object KPI_interview_countOfRecordsInDfThenWrite extends App with spark {
 spark.sparkContext.setLogLevel("ERROR")
  val inputCsv= spark.read.option("header",true).csv("writeToCsvIfCountOfRecordsAreNot0.csv")

  // write dataDframe to CSV if we have records in dataFrame
    if (inputCsv.count()!=0){
      inputCsv.write.option("header",true).csv("KPI")
    }
  else
      println("No Records in DataFrame")

}

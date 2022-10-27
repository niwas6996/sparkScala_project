import org.apache.spark.sql.SparkSession


object readCSV {

  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local[*]").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")
    val inputRDD=spark.read.option("header",true)
      .option("inferSchema",true).csv("C:\\Users\\Hemas\\OneDrive\\Desktop\\datalemur.csv")
      .createTempView("transactions")
    spark.sql("""select account_id,
                |  sum(case when transaction_type='Deposit' then amount
                |else 0 end) -
                |  sum(case WHEN transaction_type='Withdrawal' then amount
                |else 0 end) as final_balance
                |from transactions group by 1""".stripMargin).show()


  }

}

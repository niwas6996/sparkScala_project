import org.apache.spark.sql.SparkSession

object readWriteExcel {

  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local").getOrCreate()
    System.setProperty("hadoop.home.dir", "C:\\winutils")
    spark.sparkContext.setLogLevel("error")

    val inputExcelDF=spark.read.format("excel").option("header",true).option("inferSchema",true)
                     .load("C:\\Users\\Hemas\\Downloads\\MOCK_DATA.xlsx" )

    inputExcelDF.show()


  }

}


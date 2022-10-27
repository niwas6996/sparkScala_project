import com.databricks.spark.xml.XmlDataFrameReader
import org.apache.spark.sql.{Column, SparkSession}
import org.apache.spark.sql.catalyst.dsl.expressions.{DslExpression, StringToAttributeConversionHelper}
import org.apache.spark.sql.functions.col

object readXML {

  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\winutils")
    val spark=SparkSession.builder().master("local").getOrCreate()
    spark.sparkContext.setLogLevel("error")
    val xmlDF=spark.read.option("header",true).option("RowTag","record").
     option("RootTag","dataset").option("inferSchema",true)
      .xml("C:\\Users\\Hemas\\IdeaProjects\\spark-etl\\src\\resources\\input\\dataset.xml")
//    xmlDF.show(50,false)
//    xmlDF.printSchema()
    xmlDF.write.format("csv").option("header",true)
      .save("C:\\Users\\Hemas\\OneDrive\\Desktop\\output\\")


  }

}

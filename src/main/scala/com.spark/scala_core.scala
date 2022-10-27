
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.IntegerType

object scala_core extends App {

  val spark = SparkSession.builder.master("local").getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val df = spark.read.option("header", true).option("inferschema", true)
    .csv("C:\\Users\\Hemas\\OneDrive\\Desktop\\alphaNumaric.csv")

  //  df.withColumn("nums",$"id".rlike("^[0-9]*$")).show()


//  val df1 = df.filter($"id".cast("int").isNull)
//  val df2 = df.filter($"id".cast("int").isNotNull)
//
//  df1.join(df2,df1("id") =!= df2("id"),"full").show()
//   df.createTempView("alph")

  //  spark.sql(" select id,case when cast(id as int) is not null from alph ").show()
//  spark.sql(
//    """with cte as (select id,cast(id as int) as cast_id from alph)
//      |select * from (select case when cast_id is not null then id else '' end nums,
//      | case when cast_id is null then id else '' end alphabet from cte) t
//      | """.stripMargin).show()
  //  df.select(when($"id".cast("int") isNull ,"0").as("int")).show()

  //  val filterdf = df.select((when($"id".cast(IntegerType),isnull).as("int"))).show()

  //  val filterdf = df.select(when(isnull($"id".cast("string")),"")).show()
  //spark.sql(
  //  """select cast(id as int) as alphabet,
  //    cast(id as int) as numeric from alph""".stripMargin).show()

  //  spark.sql("""select case when cast(id as int) is null end as int from alph""").show()
  //  val string = spark.para("apple")
  //  string.split("").map(m=>m,1)
  ////  def evenUpper (str:String)=
  ////    str.split("")

}

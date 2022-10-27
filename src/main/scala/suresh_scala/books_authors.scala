package suresh_scala

import org.apache.spark.sql.functions.{explode, split}
import org.apache.spark.sql.types.{ArrayType, IntegerType, StringType, StructType}

object books_authors extends App with spark {
  spark.sparkContext.setLogLevel("ERROR")
  import spark.implicits._
//val schema = new StructType()
//  .add("id",IntegerType)
//  .add("name",StringType)
//  .add("author",new StructType())

    val booksDF = spark.read.option("header",true).option("delimiter","|")
      .option("inferSchema",true).csv("Books.txt")
    val authorDF = spark.read.option("header",true).csv("Authors")

  booksDF
    .withColumn("author_name",split($"author_name",","))
//    .createTempView("books")
//  authorDF.createTempView("author")
//  spark.sql("""select explode(author_name) from books""").show()

//  spark.sql(
//    """select * from books
//      |join author
//      |on
//      |(select explode(author_name) from books) = author.name """.stripMargin).show()

  booksDF.join(authorDF,explode(booksDF("author_name"))===authorDF("name"),"inner").show()

}

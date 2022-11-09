package spark_30DaysOfSpark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{struct, to_json}
import org.apache.spark.sql.Dataset
object ConvertDataFrameToNestedJson {
  case class EntityNested(entity_id: String, timestamp: Long, updates: Updates, deletes: Array[String])

  case class Updates(days_active_7d: Long, days_active_30d: Long)

  case class Entity(entity_id: String, days_active_7d: Long, days_active_30d: Long, timestamp: Long, deletes: Array[String]) {
    def toNested = EntityNested(entity_id, timestamp, Updates(days_active_7d, days_active_30d), deletes)
  }

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName(this.getClass.getName)
      .master("local")
      .config("spark.sql.warehouse.dir", "file:///tmp/spark-warehouse")
      .config("spark.sql.shuffle.partitions", "4")
      .getOrCreate()
    import spark.implicits._
    val df = Seq(
      ("a12sad123123", 0, 3, 1589611991631l, Array.empty[String])
    ).toDF("entity_id", "days_active_7d", "days_active_30d", "timestamp", "deletes")
    // Converting Dataframe to Dataset
    val intermediate: Dataset[EntityNested] = df.as[Entity].map(_.toNested)
    // Create JSON formatted column
    val kafkaDf = intermediate.select($"entity_id",
      to_json(struct($"entity_id", $"timestamp", $"updates", $"deletes"))
        .as("kafka_value"))
    kafkaDf.show(1, false)

  }
}
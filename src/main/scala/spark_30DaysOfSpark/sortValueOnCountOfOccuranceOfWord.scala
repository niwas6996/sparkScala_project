package spark_30DaysOfSpark

object sortValueOnCountOfOccuranceOfWord extends App {

  val lst = List("apple", "banana", "orange", "banana", "banana", "apple", "apple", "orange")

  def sortedVal(value: Map[String, Int]) =
    value.toSeq.sortBy(_._2)

  lst.flatMap(_.split(","))
    .map(word => (word, 1))
    .groupBy(_._1)
    .mapValues(m => m.map(_._2).sum)
    .toSeq
    .sortBy(_._2).reverse

    .foreach(println)


}

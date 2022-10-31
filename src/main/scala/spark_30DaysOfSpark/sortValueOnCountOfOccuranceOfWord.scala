package spark_30DaysOfSpark

object sortValueOnCountOfOccuranceOfWord extends App {

  val lst = List("apple", "banana", "orange", "banana", "banana", "apple", "apple", "orange")
//val lst = List(scala.io.StdIn.readLine())
  def countAndSortVal(x:List[String]):Unit= {

  x.flatMap(_.split(","))
    .map(word => (word, 1))
    .groupBy(_._1)
    .mapValues(m => m.map(_._2).sum)
    .toSeq
    .sortBy(_._2).reverse
    .foreach(println)


  }
  countAndSortVal(lst)

}

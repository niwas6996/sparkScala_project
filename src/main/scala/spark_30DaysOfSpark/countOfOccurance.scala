package spark_30DaysOfSpark

object countOfOccurance extends App {

  val str = "hai all how are you how is your family doing"

  def occurance(str: String, find: String, findWordLength: Int) =

    str.sliding(findWordLength).count(_ == find)

  println(occurance(str,"h",1))
}

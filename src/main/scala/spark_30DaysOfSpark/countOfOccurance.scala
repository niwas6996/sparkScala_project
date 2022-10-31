package spark_30DaysOfSpark

object countOfOccurance extends App {

  val str = "hai all how are you how is your family doing"
  val str2 = scala.io.StdIn.readLine()

  def occurance(str: String, find: String, findWordLength: Int) =

    str.sliding(findWordLength).count(_ == find)

  println(occurance(str,"you",3))
  println(occurance(str2,"you",3))

}

package suresh_scala

//import scala.util.control.Breaks._

object firstSmalestMissingNumberFromListOfInt extends App {

  val lst = List(1, 2, 3, 5, 6, 7, 9, 11) // missingNums(4,8,10)  output: 4
  val check = List.range(lst.min, lst.max+1)

  val result = check.diff(lst)
  println(result.min)


}

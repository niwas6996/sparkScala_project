package suresh_scala
import scala.io.StdIn.readLine

import scala.collection.mutable.ListBuffer

object filterDuplicatesFromListOfInt extends App {
//println("enter List[Int] here : ")
//  val l = readLine().toList
  val l =List(1,2,3,1)
  var dup = List[Int]().toSet
  var withoutDup = List[Int]().toSet

  for (i <- 0 to l.length - 1) {
    for (j <- i + 1 to l.length - 1) {
      if (l(i) == l(j)) {
        dup += l(i)
//        dup+=l(j)
      }
      else
        withoutDup += l(i)
    }
  }
  var uniq = withoutDup.diff(dup)
  println("dup: " + dup)
  println("withoutDup:"+withoutDup)
  println("uniq :" + uniq)
}

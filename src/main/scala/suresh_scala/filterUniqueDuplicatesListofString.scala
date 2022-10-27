package suresh_scala

import scala.collection.mutable.ListBuffer

object filterUniqueDuplicatesListofString extends App {

  val list = List("a", "b", "c", "d", "b", "c", "e", "b", "d")
  //  val list = Seq(1, 2, 3, 4, 5, 1, 2,6,6)
  var duplicate = ListBuffer[String]().toSet
  var withoutDup = ListBuffer[String]().toSet
  //var duplicate = ListBuffer[Int]().toSet
  //  var unique = ListBuffer[Int]().toSet

  for (i <- 0 until list.length - 1) {
    for (j <- i + 1 until list.length - 1) {
      if (list(i) == list(j)) {
        duplicate += list(i)
      }
      else {
        withoutDup += list(i)
      }
    }
  }
  var unique = withoutDup.diff(duplicate)
  println("duplicate: " + duplicate)
  println("unique: " + unique)

  //  list.intersect(list_set)
  //  for(i<-list){
  //    for(j<-list){
  //
  //
  //    }
  //  }

  //  val list2 = List(1,2,3,4,1,3,9,11,12)

  //  var duplicate = ListBuffer[Int]()
  //  var unique = ListBuffer[Int]()
  //
  //  for(i <- list(0) to list(list.length)) {
  //  for(j<- list(1) to list(list.length)) {
  //    println(i)
  ////    if (i==j){
  ////      duplicate+= i
  ////    }
  ////    else unique+=i
  //  }
  //  }
  ////  println(duplicate.toSet)
  ////  println(unique.toSet)
  //
  ////  for(i<-0 to list.length) {
  ////    for(j<-list){
  //
  //
  ////    }
  ////println(i)
  ////      }
  //  //filter Odd and Even numbers from list
  ////  var odd = new ListBuffer[Int]()
  ////  var even = new ListBuffer[Int]()
  //
  //  for(i<- list){
  //    if (i%2==0){
  //      even += i
  //    }
  //    else odd+= i
  //  }
  //println(odd.toSet)
  //println(even.toSet)

}

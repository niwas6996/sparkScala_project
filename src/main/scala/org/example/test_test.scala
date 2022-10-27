package org.example

import scala.collection.mutable.ListBuffer

object test_test extends App {
  val lst = List(1, 2, 3, 1, 3, 10)
//  var duplicates = ListBuffer[Int]().toSet
//  var unique = ListBuffer[Int]().toSet

  for (i <- 0 until lst.length - 1) {
    for (j <- i + 1 until lst.length - 1) {
      if (lst(i) == lst(j)) {
//        duplicates += lst(i)
        println(i)
      }
//      else {
////        unique += lst(i)
//        println("uni: "+i)
      }

    }
//    println("duplicates :" + duplicates)
//    println("unique :" + unique)



  //
  //  var take= ""
  //  for(i<- 0 to lst.length){
  //
  //    for(j<- i+1 to lst.length){
  //
  //
  //
  //      if(i==j){
  //        take+= i.toString
  //      }
  //    }
  //
  //    println(take)
  //  }

}

package spark_30DaysOfSpark

import scala.collection.mutable.ListBuffer

object sortElementsInOddPosition extends App{

  //write a program to sort odd numbers in descending ang even numbers in ascending

  val input = List(1,2,3,4,5,6,7,8,9)
var even = ListBuffer[Int]()
  var odd = ListBuffer[Int]()

  for(i<- 0 to input.length-1){
    if(input(i)%2==0){
      even+=input(i)
    }
    else
      odd +=input(i)
  }
println(odd.reverse)
println(even)
}

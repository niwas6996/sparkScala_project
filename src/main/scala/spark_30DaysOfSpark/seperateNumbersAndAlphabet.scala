package spark_30DaysOfSpark

import scala.collection.mutable.ListBuffer

object seperateNumbersAndAlphabet extends App{

  val lst = Seq(1,"a",2,"b").mkString(",")

  var nums = ListBuffer[Int]()
  var alph = ListBuffer[String]()
//  val filterd = lst.flatMap(f=>f.split(","))
println(lst)
//  for(i<-0 to lst.length-1)
//    if(lst(i)==List.range(0,lst.max))
//      nums+=lst(i)
//    else
//      alph+=lst(i)
//  println(nums)
//  println(alph)
}

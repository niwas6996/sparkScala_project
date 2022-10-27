package com.allaboutscala.learn.spark.functions

import scala.collection.mutable.ListBuffer

object loopBreakWithBoolean extends App {

  val lst = List(1,1,2,2,3,1)
  var break = true

  for(i<-lst){
    var dup = List().mkString
    for(j<- i+1 to lst.length-1){
      if(lst(i)==lst(j) & break){
        dup+=lst(i)
        break=false
        print(dup)
      }
    }
  }



}

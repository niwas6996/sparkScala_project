package com.allaboutscala.learn.spark.functions

object strReverseRecursive extends App {

  val str = "suresh"

  def revStr(str:String):String={
    (for(i<- str.length-1 to 0 by -1)
      yield str(i)).mkString
  }
  print(revStr(str))

//  val rev = str.substring(-1,0)
//  print(rev)


//  def revStr(str:String):Unit={
//    if(str.length<2) str
//    else
//      {
//        var string = ""
//        for(i<- List.range(str.length-1,0)){
//          string += str.substring(i)
//        }
////        println(string)
//      }

//  }

//  def revStr(s: String): String = {
//    if (s.length < 2) s
//    else
//      revStr()
//  }
//
}

package spark_30DaysOfSpark

import scala.collection.mutable.ListBuffer

object revStrRecusively extends App{

  val days = Array("sunday","monday","tuesday","wednesday","thursday","friday","saturday")
  val str = "hai all"
  def revStr(s:String):String= {
    if(s.length<2) s
    else
    revStr(s.substring(1))+s.charAt(0)
  }

  println(revStr(str))

//var lst = ListBuffer[Any]()
//  for(i <- 1 until 7){



//    var mappedDays =  days.map(day=>(day,i))
//  }


}

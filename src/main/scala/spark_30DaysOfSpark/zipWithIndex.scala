package spark_30DaysOfSpark

object zipWithIndex extends App {

  val days = Array("sunday","monday","tuesday","wednesday","thursday","friday","saturday")
  var res = Array[String]()
  val result = days.zipWithIndex
//    .map(m=>(m._1,m._2+1))
  result.foreach(println)



//    for(i <- 1 until 7) {
//      for(j<-days){
//        j.map(m=>(m,i))
//      }

//      var break = true
//      for(j<-days){
//
//      }
////      var mappedDays = days.flatMap(m=>m.split(",")).map(m=>(m,i))
//
////      mappedDays.foreach(println)
//    }


}

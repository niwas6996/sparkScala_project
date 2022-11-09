package spark_30DaysOfSpark
import scala.collection.mutable.ListBuffer

object KPI_Interview extends App{
    val lst = List(8,1,2,2,3)
  ////Expected output (4,0,1,1,3)
  var result = ListBuffer[Int]()
  for(i<- 0 to lst.length-1){
    var take = 0
    for(j<- lst){
      if(lst(i)>j){
        take+=1
      }
    }
    result+=take
  }
println(result.toList)
  }


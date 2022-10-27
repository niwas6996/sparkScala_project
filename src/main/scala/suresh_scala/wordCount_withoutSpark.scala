package suresh_scala

object wordCount_withoutSpark extends App {

  val list = List("Rahul Patidar", "Bangalore Pune ",
    "BigData Spark Scala Hive Hadoop Rahul Patidar "
  )

  val wordList = list.flatMap(f => f.split(" "))
  val groupVals = wordList.map(m => (m, 1)).groupBy(_._1)
  val mapVals = groupVals.mapValues(elem =>elem.map(_._2).sum)
//    .filter(value=> value=="Bangalore")
  mapVals.foreach(println)

}

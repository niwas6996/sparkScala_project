//package suresh_scala
//
//import suresh_scala.test_trait.cols
//
//object test_trait extends App with spark {
//spark.sparkContext.setLogLevel("ERROR")
//
//  val df = spark.read.csv("C:\\Users\\Hemas\\OneDrive\\Desktop\\ORDER.CSV")
//    .toDF("Id","value","value_2")
////    .filter("id%2=0 and value='A'")
//
//  var cols = df.columns
//
//  for(i<- cols){
//    var cols = i.replace("_","")
//    cols.foreach(print)
//  }
//
//
//}

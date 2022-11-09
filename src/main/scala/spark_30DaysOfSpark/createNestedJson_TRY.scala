//package spark_30DaysOfSpark
//
//object createNestedJson_TRY extends spark with App {
//
//  case class id(empId: Int)
//
//  case class name(empName: String)
//
//  case class location(loc:String)
//
//  case class details(Name: name, AGE: Int, LOCATION: location)
//
//  case class status(MARTIALSTATUS: String)
//
//  case class emp_details(ID: id, DETAILS: details, STATUS: status)
//
//
//  spark.sparkContext.setLogLevel("ERROR")
//
//  import spark.implicits._
//
//  val data = Seq((1, "suresh", "32", "HYD", "Married"),
//    ((2, "Srinu", "26", "HYD", "Single")),
//    ((3, "sai", "324", "HYD", "Single")),
//    ((4, "sateesh", "34", "HYD", "married")))
//
//  val cols = Seq("id", "name", "age", "location", "MartialStatus")
//  val df = data.toDF(cols: _*)
//
//  val nesteDF = df.map(r => {
//    val id_1 = id(r.getInt(0))
//    val name_1 = name(r.getString(8))
//    val location_1 = location(r.getString(0))
//    val details_1 = details(id_1,r.getInt(1),r.getString(2),location_1)
//
//  })
//
//}
//

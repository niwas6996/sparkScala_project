package spark_30DaysOfSpark

import org.apache.spark.sql.functions.{struct, to_json}

object createNestedJSON extends App with spark {

  import spark.implicits._

  spark.sparkContext.setLogLevel("ERROR")

  case class empId(id: String)

  case class depId(dep_id: String)

  case class details(id: empId, name: String, position: String, depId: depId)

  case class code(manager_id: String)

  case class reporting(reporting: Array[code])

  case class hireDate(hire_date: String)

  case class emp_record(emp_details: details, incrementDate: String, commission: String, country: String,
                        hireDate: hireDate, reports_to: reporting)

  val DF = Seq(("64989", "ADELYN", "SALESMAN", "66928", "1991-02-20", "1700.00", "400.00", "3001", "2000-02-20", "France"),
    ("64999", "Raj", "SALESMAN", "66928", "1991-02-20", "1700.00", "400.00", "3001", "2000-02-20", "Ind"))
    .toDF("emp_id", "emp_name", "job_name", "manager_id", "hire_date", "salary",
      "commission", "dep_id", "increment_date", "country")
  DF.show()

  val nestedDF = DF.map(r => {
    val empID_1 = empId(r.getString(0))
    val depId_1 = depId(r.getString(7))
    val details_1 = details(empID_1, r.getString(1), r.getString(2), depId_1)
    val code_1 = code(r.getString(3))
    val reporting_1 = reporting(Array(code_1))
    val hireDate_1 = hireDate(r.getString(4))
    emp_record(details_1, r.getString(8), r.getString(6), r.getString(9), hireDate_1, reporting_1)

  })
nestedDF.show(false)
nestedDF.printSchema()
  //  nestedDF.show(false)
  //  nestedDF.printSchema()
  //  val cols = DF.columns.toList.flatMap(_.split(",")).map(elem=>"""+elem+""").mkString(",")
  DF.withColumn("nested", to_json(struct("emp_id", "emp_name", "job_name", "manager_id", "hire_date", "salary",
    "commission", "dep_id", "increment_date", "country")))
    .drop("emp_id", "emp_name", "job_name", "manager_id", "hire_date", "salary",
      "commission", "dep_id", "increment_date", "country")
//    .show(false)

}

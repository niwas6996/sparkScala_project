package spark_30DaysOfSpark

import spark_30DaysOfSpark.toNestedJson_CaseClass_package._

object createNestedJson_TRY extends spark with App {

  import spark.implicits._

  val df = Seq(("64989", "ADELYN", "SALESMAN", "66928", "1991-02-20", "1700.00", "400.00", "3001", "2000-02-20", "France"),
    ("64999", "Raj", "SALESMAN", "66928", "1991-02-20", "1700.00", "400.00", "3001", "2000-02-20", "Ind"))
    .toDF("emp_id", "emp_name", "job_name", "manager_id", "hire_date", "salary",
      "commission", "dep_id", "increment_date", "country")

  val nestedDf = df.map(x => {
    val empId_1 = empID(x.getString(0))
    val empName_1 = empNAME(x.getString(1))
    val depId_1 = depID(x.getString(7))
    val empDetails_1 = empDETAILS(empId_1, empName_1, x.getString(2))
    val managerId_1 = mngrID(x.getString(3))
    val hireDATE_1 = hireDATE(x.getString(4))

  emp_record(empDetails_1,x.getString(8),x.getString(6),x.getString(9),hireDATE_1,managerId_1,depId_1,x.getString(5))
  }
  )
nestedDf.show(false)


//  spark.sql(""" select int(date_format(add_months(current_date,-1),'YYYY')) """).show()

}
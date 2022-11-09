package spark_30DaysOfSpark

object toNestedJson_CaseClass_package extends App{

  case class empID(id:String)
  case class empNAME(name:String)
  case class depID(dID:String)
  case class empDETAILS(id:empID,name:empNAME,role:String)
  case class mngrID(mID:String)
  case class hireDATE (hire_date:String)
  case class emp_record(record:empDETAILS,incrementDate:String,commission:String,country:String,hireDate:hireDATE,reportsTO:mngrID,depID:depID,salary:String)




}

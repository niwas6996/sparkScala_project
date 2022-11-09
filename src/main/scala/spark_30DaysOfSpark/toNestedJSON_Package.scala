package spark_30DaysOfSpark

object toNestedJSON_Package extends App {

  case class name(N: String)

  case class age(a: String)

  case class loc(l: String)

  case class details(NAME: name, AGE: age, LOC: loc)

  case class lang1(l: String)

  case class lang2(l: String)

  case class lang3(l: String)

  case class language(l1: lang1, l2: lang2, l3: lang3)

  case class languages(lng: Array[language])

  case class record(id: String, details: details, salary: String, role: String, languages_known: languages)

}

package spark_30DaysOfSpark


object coforge_interViewQuestion extends App {

  val thirdCharToUpper = (str: String) =>
    if (str.length < 3) str
    else
      str.substring(0, 2) + str.substring(2, 3).toUpperCase + str.substring(3, str.length)

  val sample_string = Seq("hai hannu baby i love you")

  val splitString = sample_string.flatMap(f => f.split(" "))
    .map(word => thirdCharToUpper(word)).mkString(" ")

  println(splitString)

  val countWords = sample_string.flatMap(_.split(" "))
  var count = 0
  for (i <- countWords) {
    count += 1
  }
  println("count of words : " + count)

}

package suresh_scala

object exercise extends App {
  println("Write a Scala program to compute the sum of the two given integer values. " +
    "If the two values are the same, then return triples their sum")

  val add = (x: Int, y: Int) => x + y

  def addIf(x: Int, y: Int) =
    if (x == y) {
      add(x, y) * 3
    }
    else add(x, y)

  println("difNums: " + addIf(2, 3))
  println("sameNums: " + addIf(2, 2))

  println("Write a Scala program to get the absolute difference between n and 51. " +
    "If n is greater than 51 return triple the absolute difference")

  def absoluteDiff(n: Int) =
    if (n < 51) {
      51 - n
    }
    else (n - 51) * 3


  println("n=41:" + absoluteDiff(41))
  println("n=61:" + absoluteDiff(61))

  println(" Write a Scala program to check two given integers, " +
    "and return true if one of them is 30 or if their sum is 30")

  def checkInt(x: Int, y: Int): Boolean = {
    if (x + y == 30 | (x | y) == 30)
      return true
    else
      return false
  }

  println(checkInt(20, 10))
  println(checkInt(30, 0))
  println(checkInt(2, 10))


  println("Write a Scala program to check a given integer and return true " +
    "if it is within 20 of 100 or 300")

  def checkRange(x: Int): Boolean = {
    Math.abs(100 - x) <= 20 || Math.abs(300 - x) <= 20
  } //coppied

  println(checkRange(119))

  println("Write a Scala program to create a new string where 'if' is added to the front of a given string." +
    " If the string already begins with 'if', return the string unchanged.")

  def strIf(str: String) =
    if (str.startsWith("if")) str
    else
      "if " + str //coppied

  println("if we have: " + strIf("if we have"))
  println("we have: " + strIf("we have"))


  println("Write a Scala program to exchange the first and last characters in a given string and return the new string.")

  def strIndexSwap(x: String) =
    if (x.length == 1) x
    else
      x.charAt(x.length - 1) + x.substring(1, x.length - 1) + x.charAt(0) //coppied

  println(strIndexSwap("apple"))

  println("Write a Scala program to create a new string taking the first 3 characters of a given string " +
    "and return the string with the 3 characters added at both the front and back. If the given string length is less than 3, " +
    "use whatever characters are there")

  def strChange(x: String) =
    if (x.length < 3) x
    else
      x.substring(0, 3) + x + x.substring(0, 3)

  println(strChange("apple"))

  println("Write a Scala program to check whether a given string starts with 'Sc' or not")

  def startsWithSc(str: String) = {
    //    if (str.startsWith("Sc")||str.startsWith("sc"))// approach_1 (ok)
    //    if(str.substring(0,2)=="sc" || str.substring(0,2)=="Sc") // approach_2 (ok)
    if (str.charAt(0) + str.substring(0, 0) + str.charAt(1) == "Sc")
      "starts with Sc"
    else
      "false"
  }

  println(startsWithSc("Scala"))
  println(startsWithSc("scala"))


  println("Write a Scala program to check whether a given character presents in a string between 2 to 4 times")

  def checkCharInSring(str: String, str2: String) = {
    var counter = str.sliding(2).count(c => c == str2) //coppied (implimented with sliding)
    println(counter)
  }

  checkCharInSring("apple", "ap")

  println("count of occurances of chars in a string")

  def countOfOccurance(x: String) = {
    var counter = x.groupBy(e => e).map(m => (m._1, m._2.length)).mkString(",")
    //      .toString().reduce(_+_)
    //      .replaceAll("[,(\")]","")
    //    var counter = x.groupBy(identity).mapValues(_.map(_=>1)).toString().reduce(_+_)
    println(counter)
  }

  countOfOccurance("apple1212")

  println("Write a Scala program to convert the last 4 characters of a given string in upper case. " +
    "If the length of the string has less than 4 then uppercase all the characters.")

  def lastFourUpperCase(str: String) =
    if (str.length <= 4) str.toUpperCase
    else
      str.substring(0, str.length - 5) + str.substring(str.length - 4, str.length).toUpperCase


  println(lastFourUpperCase("lastfouruppercase"))
  println(lastFourUpperCase("last"))


  println("find index ")

  def findIndex(str: String, char: String) =

    str.indexOf(char)

  println(findIndex("apple", "e"))

}

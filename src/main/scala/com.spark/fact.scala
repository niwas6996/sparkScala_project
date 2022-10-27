
object fact extends App {
  def fact(x: Int): Int =
    if (x <= 1) 1
    else
      x * fact(x - 1)
  //println(fact(4))

  val palindrome = "12343213"

  def ispalindrome(str: String): Unit = {
    if (str == str.reverse) {
      println("ispalindrome")
    }
    else
      println("isnotpalindrome")
  }
  //  ispalindrome(palindrome)

  val list = List(1, 2, 3, 3, 2, "a", "a", "b")
  var unique = ""
  var duplicate = ""

  def rmvDup(x: List[Any]): Unit = {
    for (i <- 0 to x.length - 1) {
      for (j <- i + 1 to x.length - 1) {
        if (i == j) {
          duplicate += i
        }
      }
      unique += i
    }
    println(unique)
    println(duplicate)
  }
  //  rmvDup(list)

  def fib(n: Int): Int = {
    if (n < 3) 1
    else fib(n - 1) + fib(n - 2)

  }
  for {i <- List.range(0, 10)}
    yield {
      println((fib(i)))
    }

//  val l = List(List(1,2), List(3,4,List(5,6)))

  val l = List(List(1,1),2,List(3,List(5,8)))

}



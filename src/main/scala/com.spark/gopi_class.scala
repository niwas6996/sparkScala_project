
object gopi_class extends App {

  val list = List(1, 2, 3, 2, 3)

  var duplicate = 0
  var unique = 0
  for (i <- 0 to list.length - 1) {
    for (j <- i + 1 to list.length - 1) {
      if (i == j)
        duplicate += i
      else unique += i
    }
    println(duplicate)
    println(unique)
  }


  def factorial(num: Int): Int = {
    if (num < 2) 1
    else {

      num * factorial(num - 1)
    }
  }

  //  println(factorial(6))


  //  val palindrome = "abcdedcba"
  //  val rev_palindrome = palindrome.reverse
  //
  //  if(palindrome==rev_palindrome){
  //    println("is palindrome")
  //  }
  //  else
  //    println("is not palindrome")

  //  println(rev_palindrome)

  val lst = List(1, 2, 3, 4, 1, 2)
  for (i <- lst) {
    for (j <- lst) {
      if (i == j) {
        println()
      }
    }

  }

  //  var uniqueLst = ListBuffer()
  //  var duplicate = ListBuffer()
  //
  //  for (i <- 0 to lst.length - 1) {
  //    var isDuplicate = false
  //    for (j <- i + 1 to lst.length - 1) {
  //      if (lst(i) == lst(j)) {
  //        isDuplicate = true
  //      }
  //    }
  //    if (isDuplicate) {
  //      duplicate :+ lst(i)
  //    } else {
  //      uniqueLst :+ lst(i)
  //    }
  //
  //  }
  //
  //  println(duplicate)
  //  println(uniqueLst)

}

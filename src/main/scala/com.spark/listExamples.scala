// Scala_Lists...collection of immutable homogeneous elements

object listExamples {
  val myList: List[Int]=List(1,2,3,4,5,6)       // Creation of Lists
  val list1=List()

  val myNames: List[String]=List("Hema","Anu","Swetcha","Venu")

  def main(args: Array[String]): Unit = {
    println(myList)         // List(1,2,3,4,5,6)

    println(myNames)        // List(Hema,Anu,Swetcha,Venu)

    println(0 :: myList)    // List(0, 1, 2, 3, 4, 5, 6)....Pre-appending the list with '0' using cons

    println(1 :: myList)    // List(1, 1, 2, 3, 4, 5, 6)

    //  println(myList :: 10)   ....gives the error(we can't post-append the list

    println(Nil)            // List()

    println(1 :: 2 :: Nil)    // List(1, 2)

    println(myList.head)       // 1
    println(myList.last)       //6
    println(myList.tail)      // List(2, 3, 4, 5, 6)..gives all elets except head
    println(myList.max)       // 6
    println(myList.isEmpty)    // false
    println(myList.reverse)    // List(6, 5, 4, 3, 2, 1)
    println("index of list example: ")
    println(myList.indexOf(5))    //4
    // print the each element of list
    myList.foreach(println)     //  1 2 3 4 ..new line

    // print each element of list using for loop
    for(x <- myNames)
      println(x)                    // Hema   Anu  Swetcha    Venu

    // creating the uniform list
    println("creating the uniform list:")
    val uniform_list=List.fill(5)(2)
    println(uniform_list)



  }


}

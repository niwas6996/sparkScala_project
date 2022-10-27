package suresh_scala

object interviews extends App {

  val lst = List(18, 16, 17, 4, 3, 5, 2)

  for (i <- lst.indices) {
    for (j <- i + 1 to lst.length - 1) {
      var leader = List[Int]()

      if (lst(i) > lst(j)) {
        leader :+= lst(i)
        println(leader)
      }


    }

  }

}

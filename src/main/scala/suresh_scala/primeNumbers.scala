package suresh_scala

object primeNumbers extends App {
  for (i <- 2 to 100) {
    var x = 0
    for (j <- 2 to 100)
      if (i % j == 0)
        x = x+j
        if (x == i)
          println(i)

  }


}

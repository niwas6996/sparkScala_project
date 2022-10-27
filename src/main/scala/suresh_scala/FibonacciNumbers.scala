package suresh_scala

object FibonacciNumbers extends App {

  def fib(x:Int):Int=
    if(x<3) 1
    else
      fib(x-1)+fib(x-2)

    for (i <- List.range(1, 11))
       println(fib(i))





}

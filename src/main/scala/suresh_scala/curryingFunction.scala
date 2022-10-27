package suresh_scala

object curryingFunction extends App{

  def curryfun(x: Int, y: Int, f: Int => Int): Int = {
    f(x) + f(y)
  }
  println(curryfun(1,2, x => x * x * x))

}

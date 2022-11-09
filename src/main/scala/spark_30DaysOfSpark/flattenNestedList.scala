package spark_30DaysOfSpark

object flattenNestedList extends App {

  val lst = List(1, 2, List(3, 4, List(5, 6)), List(7, 8))

  def flat(l: List[Any]):List[Any] = l flatMap {

    case ls:List[_] => flat(ls)
    case h=> List(h)
  }
  println(flat(lst))

}

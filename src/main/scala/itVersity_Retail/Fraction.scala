package itVersity_Retail

class Fraction(n:Int,d:Int) {
  override def toString= n+"/"+d
  def result = n/d.toDouble
}
object Fraction extends App{
  val f = new Fraction(2,4)
  println(f)
  println(f.result)

}
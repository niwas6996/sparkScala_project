package spark_30DaysOfSpark

import itVersity_Retail.Fraction.f

object higherOrderFunction extends App{

  def higherOrderFunction(x:Int,y:Int,f:(Int,Int)=>Int)=f(x,y)


  val test = higherOrderFunction(1,2,(x,y)=>x min y)
  println(test)

}

package spark_30DaysOfSpark

object reverseString extends App{

//  val str = "hai how are you"
  val str = scala.io.StdIn.readLine()
  var revStr = ""

  for(i<- 1 to str.length) {
    if(str.length<2) str
    else
      revStr+= str.substring(str.length-i,str.length-(i-1))

  }
  println(revStr)

}



object practice extends App {

  // println(primn 2 to 100 prime numbers)
//  for (i<- 2 to 100){
//
//    var prime = 0
//    for(j<- 2 to i){
//      if(i%j==0)
//        prime+=j
//
//      if(prime==i){
//        println(prime)
//      }
//    }
//  }

//  println("check for palindrome")
//  val list = "123454321"
//  if(list==list.reverse){
//    println(list+" is a palindrome")}
//    else
//    println(list+" is not a palindrome")

//  println("print factorial")

//  def factorial(x:Int):Int=
//    if (x<1) 1
//    else
//      x*factorial(x-1)
//
//  println(factorial(4))

//  println("febonacci series")



//  println("remove duplicates")

  val list = List(1,2,3,3,2,4,5,7)
  for (i<- 0 to list.length){
    var unique = ""
    for(j<- 0 to list.length){
      if(i!=j){
        unique=unique+i
      }
    }
    println(unique)
  }
}

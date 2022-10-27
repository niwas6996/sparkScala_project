package itVersity_Retail

object itVersity extends App {

  //  class Department(var DepId: Int, var DepName: String);
  //  val department = new Department(1, "IT")
  //  println(department.DepName)
  class employee(val id: Int, val name: String, val depId: Int)

  class department(val depId: Int, val depName: String)

  val emp = new employee(101, "suresh", 1234)
  val dep = new department(1234, "IT")

  println(emp.name, emp.depId, dep.depName)

  //apply method start
  class A(val i: Int) {
    def apply = println("inside class apply ")
  }

  object A {
    def apply(i: Int) = {
      new A(i)
    }
  }

  val a = A(10)
  println(a.i)
  //apply method end


  val oi = new OrderItem(1, 1, 1,
    3, 150, 50)
  println(oi.orderItemSubTotal)

  def intToString(num: Int) = num match {
    case 1 => "one"
    case 2 => "two"
    case _ => "none"
  }

  println(intToString(2))






//  val s = "apple banana orange apple orange banana"
//  def countWithGroupBy(s:String)= {
//    s.groupBy(identity).mapValues(_.map(_ => 1)).toString().reduce(_+_)
//  }
//  println(countWithGroupBy(s))

}

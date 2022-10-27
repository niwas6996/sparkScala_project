object list_operations {
  def main(args: Array[String]): Unit = {
    val list1=List(1,4,7,3,8,9,6,7,4,9)
    val list2=List(3,6,9,7,2,4,9)

    //merging of two lists
    println("merging of two lists in two ways: ")
    val list3=list1 ++ list2
    println(list3)
    val list4= list1 ::: list2
    println(list4)

    // find the odd and even numbers from a list
    println("even and odd lists:")
    val even_list=list1.filter(_%2 == 0)
    println(even_list)
    val odd_list=list1.filter(_%2!=0)
    println(odd_list)
    //  remove duplicates from a list
    println("remove duplicates from a list")
    val list5=list1.distinct
    println(list5)
    //  remove duplicates from a list by convert list into a set
    val set1=list1.toSet
    println(set1)

    //  sorting a given ist
    println("sorting the list of elements")
    val sorted_lst=list1.sorted
    println(sorted_lst)


  }

}

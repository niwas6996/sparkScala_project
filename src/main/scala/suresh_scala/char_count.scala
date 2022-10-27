package suresh_scala

object char_count {

  def main(args: Array[String]): Unit = {

    val str = Seq("suresh")
    //    val hs_map = new
    val result = str.flatMap(f => f.split(""))
      .map(char => (char, 1)).groupBy(_._1)
      .mapValues(i => i.map(_._2).sum)

    result.foreach(println)

    //    for(i<- str_array){
    //println(result)

    //    }


  }

}

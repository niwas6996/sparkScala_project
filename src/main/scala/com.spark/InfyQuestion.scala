object InfyQuestion {
  def main(args: Array[String]): Unit = {
    val s="Lavanya jipsu dolor sit amet, consequences additionalfeatures elit."

    val output=s.split(" ")
      .map(x=>(x,x.trim.replace(".","")
        .replace(",","").length))
      .sortBy(y=>(-y._2,y._1.toLowerCase()))
     .map(z=>z._1.replace(".","")
       .replace(",","").toLowerCase()).mkString(" ")
    println(output)
  }
}

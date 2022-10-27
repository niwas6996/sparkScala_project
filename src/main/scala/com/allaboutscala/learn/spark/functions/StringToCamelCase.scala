package com.allaboutscala.learn.spark.functions

object StringToCamelCase extends App {

//  def toCamelCase(col:String)=
//    col.

//  def camel2Underscore(text: String) = text.drop(1)
//      .foldLeft(text.headOption.map(_.toLower + "") getOrElse "") {
//    case (acc, c) if c.isUpper => acc + "_" + c.toLower
//    case (acc, c) => acc + c
//  }

  def toCamel(s: String): String = {
    val split = s.split(" ")
    val head = split.head
    val tail = split.tail.map(x => x.head.toUpper + x.tail)

    head + tail.mkString
  }

  println(toCamel("with column renamed"))

}



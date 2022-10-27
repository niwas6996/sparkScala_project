package spark_30DaysOfSpark

import suresh_scala.spark
import com.typesafe.config.{Config,ConfigFactory}

object typeSafety extends App with spark {

  val applicationConf:Config = ConfigFactory.load("Application.conf")
  val appName = applicationConf.getString("app.email")
  println(appName)


}

package spark_30DaysOfSpark

import com.typesafe.config.ConfigFactory

object typeSafety extends App with spark {

  val applicationConf= ConfigFactory.load("Application.conf")
  val appName = applicationConf.getString("cred.user_name")
  val login_id = applicationConf.getString("data.login_id")
  println(appName)
  println(login_id)


}

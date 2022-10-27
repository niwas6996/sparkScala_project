import org.apache.spark.sql.SparkSession

object spark_sql extends App{

  val spark = SparkSession.builder().master("local").getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  import spark.implicits._
  val columns = Seq("id","name","dep","salary")
  val data = Seq((1,"abc","IT",25000),(2,"def","IT",15000),(3,"der","IT",35000),
    (4,"ser","Adm",22000),(5,"wer","Adm",5000),(6,"jhy","Adm",45000),
    (7,"dse","Adm",34000),(8,"qwe","Adm",21000),(9,"der","IT",19000),(10,"ert","Adm",23800))
  val df = data.toDF(columns:_*).createTempView("emp")
  spark.sql(
    """select e1.* from (select *,round(avg(salary) over(partition by dep)) avg_sal from emp) e1
      |where e1.salary>e1.avg_sal
      |""".stripMargin).show()

//  spark.sql("""create table emp (id int,name string,dep string,salary int)""").show()

}

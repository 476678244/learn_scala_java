package org.zonghan.practicespark

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkSessionTest extends App {
  val path = getClass.getResource("/access-code-password-recovery-code.csv").getPath

  val conf = new SparkConf().setAppName("SparkExample").setMaster("local[*]")

  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .master("local[*]")
    .getOrCreate()

  val df = spark.read.option("header", "true").option("delimiter", ";").csv(path)
  df.show()
}

package org.zonghan.practicespark

import org.apache.spark.{SparkConf, SparkContext}

object SparkContextTest extends App {
  val path = getClass.getResource("/access-code-password-recovery-code.csv").getPath

  val conf = new SparkConf().setAppName("SparkExample").setMaster("local[*]")
  val sc = new SparkContext(conf)
  val data = sc.textFile(path).collect()
  data.foreach(line => {
    println(line)
  })
}

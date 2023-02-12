package org.zonghan.practicespark

import org.apache.spark.sql.SparkSession

object DeltaLakeTest extends App {
  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .config("spark.sql.extensions", "io.delta.sql.DeltaSparkSessionExtension")
    .master("local[*]")
    .getOrCreate()
  val data = spark.range(0, 5)
  data.write.format("delta").save("/tmp/delta-table")

  val df = spark.read.format("delta").load("/tmp/delta-table")
  df.show()
}

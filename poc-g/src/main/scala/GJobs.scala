import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}


object GJobs {




  def gJob(csvPath:String, parquetPath:String,
           spark: SparkSession, sc: SparkContext, sqlContext: SQLContext ): Unit = {
    import spark.implicits._

    val df = spark.read
      .options(Map("inferSchema"->"true","delimiter"->",","header"->"true"))
      .csv(csvPath)

    df.show()
    df.printSchema()

    df.write.mode("append").partitionBy("customer", "year", "month","day")
      .parquet(parquetPath)


  }

}

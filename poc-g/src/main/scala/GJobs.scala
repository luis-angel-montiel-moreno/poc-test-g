import org.apache.spark.sql.functions.{col, lit}
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}


object GJobs {

  def gBackupJob(csvPath:String, parquetPath:String,
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

  /* Example of two different ways to execute SQL queries */
  def sqlQueryParquet(pathParquet: String, tableName:String, query: String,
                      spark: SparkSession, sc: SparkContext, sqlContext: SQLContext ): Unit = {
    val parquetDF = spark.read.parquet(pathParquet)
    parquetDF.createOrReplaceTempView(tableName)
    val dfQ = spark.sql(query)
    dfQ.explain()
    dfQ.printSchema()
    dfQ.show()

    val parquetPartitionedDF = spark.read
      .parquet(Main.parquetPath + "/customer=hugo")
    val dfx = parquetPartitionedDF.select(col("data")).where(col("year")===lit(2023))
    dfx.show()
  }

}

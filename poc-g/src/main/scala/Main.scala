object Main {
  val csvPath: String = "/home/luis/projects/poc-test-g/poc-g/src/resources/input/csv/sample_1.csv"
  val parquetPath:String = "/home/luis/projects/poc-test-g/poc-g/src/resources/output/parquet/sample_1.parquet"

  def main(args: Array[String]): Unit = {
    SparkBooster.init()
    GJobs.gJob(csvPath, parquetPath,
               SparkBooster.spark, SparkBooster.sc, SparkBooster.sqlContext)
    SparkBooster.close()
  }

}

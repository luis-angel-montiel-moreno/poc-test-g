object Main {
  val csvPath: String = "/home/luis/projects/poc-test-g/poc-g/src/resources/input/csv"
  val parquetPath:String = "/home/luis/projects/poc-test-g/poc-g/src/resources/output/parquet/customers.parquet"

  def main(args: Array[String]): Unit = {
    SparkBooster.init()
    GTasks.backupCSVFiles(csvPath)
    SparkBooster.close()
  }

}

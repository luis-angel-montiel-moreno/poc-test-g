import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}

object Main {
  val csvPath: String = "/home/luis/projects/poc-test-g/poc-g/src/resources/input/csv"
  val parquetPath:String = "/home/luis/projects/poc-test-g/poc-g/src/resources/output/parquet/customers.parquet"
  val parqueTableName: String = "Customers"
  val query : String = s"Select data from $parqueTableName c where c.customer='hugo'"

  def main(args: Array[String]): Unit = {
    SparkBooster.init()
    GTasks.backupCSVFiles(csvPath)
    GJobs.sqlQueryParquet(Main.parquetPath, Main.parqueTableName, Main.query,
                          SparkBooster.spark, SparkBooster.sc, SparkBooster.sqlContext)
    SparkBooster.close()
  }

}

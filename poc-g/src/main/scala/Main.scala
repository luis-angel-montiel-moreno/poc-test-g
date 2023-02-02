import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}

object Main {

  def main(args: Array[String]): Unit = {
    SparkBooster.init()
    GTasks.backupCSVFiles(TaskCSVBackupProperties.csvPath)
    GJobs.sqlQueryParquet(TaskCSVBackupProperties.parquetPath,
                          TaskCSVBackupProperties.parqueTableName,
                          TaskCSVBackupProperties.query,
                          SparkBooster.spark, SparkBooster.sc, SparkBooster.sqlContext)
    GJobs.sqlQueryParquetPartitionedExample(TaskCSVBackupProperties.parquetPath,
                                            TaskCSVBackupProperties.parqueTableName,
                                            TaskCSVBackupProperties.query,
                                            SparkBooster.spark,
                                            SparkBooster.sc,
                                            SparkBooster.sqlContext)
    SparkBooster.close()
  }

}

object TaskCSVBackupProperties {
  val csvPath: String = "/home/luis/projects/poc-test-g/poc-g/src/resources/input/csv"
  val parquetPath: String = "/home/luis/projects/poc-test-g/poc-g/src/resources/output/parquet/customers.parquet"
  val parqueTableName: String = "Customers"
  val query: String = s"Select data from $parqueTableName c where c.customer='hugo'"

}

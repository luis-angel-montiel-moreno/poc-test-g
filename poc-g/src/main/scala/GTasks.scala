import java.nio.file.{FileSystems, Files}
import scala.jdk.CollectionConverters

object GTasks {
  
  def backupCSVFiles(path : String ): Unit = {
    val dir = FileSystems.getDefault.getPath(path)
    Files.list(dir).forEach(p => println(p.toString))
    Files.list(dir)
      .forEach(csvPath =>
        GJobs.gBackupJob(csvPath.toString, Main.parquetPath,
          SparkBooster.spark, SparkBooster.sc, SparkBooster.sqlContext ))
  }


}

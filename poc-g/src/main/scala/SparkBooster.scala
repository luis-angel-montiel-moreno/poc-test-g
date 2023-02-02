import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}


object SparkBooster {
  val appName:String = "POC-G"
  val master = "local[*]"

  var conf: SparkConf = null
  var spark: SparkSession = null
  var sc : SparkContext = null
  var sqlContext: SQLContext = null

  def init(): Unit = {
    conf = new SparkConf()
      .setAppName(appName)
      .setMaster(master)
    spark =  SparkSession.builder().config(conf).getOrCreate()
    sc = spark.sparkContext
    sqlContext = spark.sqlContext
  }

  def close(): Unit = {
    spark.close()
  }

}

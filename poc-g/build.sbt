name := "poc-g-project"
version := "1.0"
scalaVersion := "2.13.10"

val sparkVersion = "3.3.1"

// Note the dependencies are provided
libraryDependencies ++= Seq(
                  "org.apache.spark" %% "spark-core" % sparkVersion,
                  "org.apache.spark" %% "spark-sql" % sparkVersion,
                  "org.apache.spark" %% "spark-streaming" % sparkVersion,
                  "org.apache.spark" %% "spark-mllib" % sparkVersion,
                  "org.apache.spark" %% "spark-tags" % sparkVersion
)
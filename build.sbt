name := "learnscala"

version := "1.0"
//jdk -> 1.8
scalaVersion := "2.12.5"

resourceDirectory in Compile := file(".") / "./src/resources"
resourceDirectory in Runtime := file(".") / "./src/resources"

unmanagedClasspath in (Compile, runMain) += baseDirectory.value / "./src/resources"


libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % Test

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.12"

libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.4.0"
libraryDependencies += "org.mockito" % "mockito-core" % "4.5.1"
libraryDependencies += "junit" % "junit" % "4.13.2"

//spark
val sparkVersion = "3.2.1"
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-mllib" % sparkVersion
libraryDependencies += "io.delta" %% "delta-core" % "1.1.0"

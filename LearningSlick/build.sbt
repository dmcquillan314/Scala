name := "LearningSlick"

version := "1.0"

scalaVersion := "2.10.2"

libraryDependencies ++= List(
  // use the right Slick version here:
  "com.typesafe.slick" %% "slick" % "1.0.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "mysql" % "mysql-connector-java" % "5.1.26",
  "org.xerial" % "sqlite-jdbc" % "3.6.20"
)
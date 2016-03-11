name := "nn"

version := "1.0"

scalaVersion := "2.11.6"


//libraryDependencies += "com.azavea.geotrellis" % "geotrellis_2.10" % "0.9.2"
libraryDependencies ++= Seq("com.azavea.geotrellis" % "geotrellis-slick_2.11" % "0.10.0-M1",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test")
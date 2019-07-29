name := "Pairing Exercise"

scalaVersion := "2.12.8"

fork in (Test, run) := true

javaOptions in (Test, run) += "-Xmx8G"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.6" % "test"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.6"
 

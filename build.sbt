name := "scalasnippets"

version := "1.0"

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
  "org.specs2" %% "specs2" % "latest.integration" % "test",
  "org.specs2" %% "specs2-scalaz-core" % "latest.integration" % "test",
  "junit" % "junit" % "latest.integration" % "test",
  "org.hamcrest" % "hamcrest-all" % "latest.integration" % "test",
  "org.pegdown" % "pegdown" % "latest.integration" % "test"
)
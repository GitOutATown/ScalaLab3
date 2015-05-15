name := "ScalaLab3"

version := "0.1"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "org.scalanlp" % "breeze-viz_2.10" % "0.5.1",
  "org.scalanlp" % "breeze_2.10" % "0.9",
  "org.scalanlp" % "breeze-natives_2.10" % "0.9",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.2" % "test",
  "org.scala-lang.modules" %% "scala-async" % "0.9.2"
)

resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
name := "ScalaLab3"

version := "0.1"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "org.scalanlp" % "breeze-viz_2.10" % "0.5.1",
  "org.scalanlp" % "breeze_2.10" % "0.9",
  "org.scalanlp" % "breeze-natives_2.10" % "0.9",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test",
  "org.scala-lang.modules" %% "scala-async" % "0.9.2",
  "joda-time" % "joda-time" % "2.9",
  "org.joda" % "joda-convert" % "1.8"
)

resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
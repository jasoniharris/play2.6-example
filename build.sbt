name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "org.mockito" % "mockito-core" % "1.9.0" % "test",
  "org.jsoup" % "jsoup" % "1.10.2" % "test",
  "com.github.tomakehurst" % "wiremock" % "2.5.1" % "test",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0-RC1" % "test",
  guice
)
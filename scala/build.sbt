import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"

lazy val root = (project in file("."))
  .settings(
    name := "fun-pro",
    libraryDependencies += scalaTest % Test
  )

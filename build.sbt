lazy val runnerDependencies = Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.5",
  "com.typesafe.akka" %% "akka-agent" % "2.3.5",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.5",
  "commons-lang" % "commons-lang" % "2.6",
  "org.scala-lang" % "scala-compiler" % "2.11.7",
  "org.scala-lang" % "scala-reflect" % "2.11.7",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "com.typesafe" % "config" % "1.2.1"
)

lazy val monty = (project in file(".")).
  settings(
    name := "monty",
    version := "0.0.1",
    scalaVersion := "2.11.7",
    fork in run := false,
    libraryDependencies ++= runnerDependencies
  )

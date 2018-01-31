name := "akka-persistence-ramblings"

version := "0.1"

scalaVersion := "2.12.4"

val akkaVersion = "2.5.3"

val akkaTestKitVersion = akkaVersion
val akkaPersistenceVersion = "2.5.4"
val akkaPersistenceJdbcVersion = "3.2.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-persistence" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaTestKitVersion % "test",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"

  ,"com.github.dnvriend" %% "akka-persistence-jdbc" % akkaPersistenceJdbcVersion
  ,"postgresql" % "postgresql" % "9.1-901-1.jdbc4"
)
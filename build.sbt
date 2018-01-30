name := "akka-persistence-ramblings"

version := "0.1"

scalaVersion := "2.12.4"

val akkaVersion = "2.5.3"
// val akkaTestKitVersion = "2.5.6"
val akkaTestKitVersion = akkaVersion
val akkaPersistenceVersion = "2.5.4"
val akkaPersistenceJdbcVersion = "3.2.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-persistence" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaTestKitVersion % "test",
  // "com.github.dnvriend" %% "akka-persistence-jdbc" % akkaPersistenceJdbcVersion,
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"


  // ,"com.github.dnvriend" %% "akka-persistence-inmemory" % "2.5.1.1"
  , "com.typesafe.akka" %% "akka-persistence-cassandra" % "0.80"

//  , "org.iq80.leveldb" % "leveldb" % "0.7"
//  , "org.fusesource.leveldbjni" % "leveldbjni-all" % "1.8"
)
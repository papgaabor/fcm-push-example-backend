name := """akka-push-notification"""

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",

  "com.fasterxml.jackson.core" % "jackson-core" % "2.9.1",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.1",

  "org.igniterealtime.smack" % "smack-java7" % "4.2.1",
  "org.igniterealtime.smack" % "smack-tcp" % "4.2.1",
  "org.igniterealtime.smack" % "smack-extensions" % "4.2.1"
)
  

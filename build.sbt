name := "NewServer" 
 
version := "0.0.0" 
 
scalaVersion := "2.9.3"


resolvers ++= Seq(
  "Sonatype" at "http://oss.sonatype.org/content/repositories/public",
  "Typesafe" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "com.github.jdegoes" %% "blueeyes-core"  % "0.6.1-SNAPSHOT",
  "com.github.jdegoes" %% "blueeyes-mongo" % "0.6.1-SNAPSHOT",
  "com.github.jdegoes" %% "blueeyes-json"  % "0.6.1-SNAPSHOT",
  "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime",
  "com.typesafe.akka" % "akka-actor" % "2.0.1"
)

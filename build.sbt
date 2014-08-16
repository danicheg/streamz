name := "streamz"

organization in ThisBuild := "com.github.krasserm"

version in ThisBuild := "0.1-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.2"

resolvers in ThisBuild += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in ThisBuild ++= Seq("-feature", "-language:higherKinds", "-language:implicitConversions")

libraryDependencies in ThisBuild ++= Seq(
  "com.typesafe.akka" %% "akka-testkit" % Version.Akka      % "test",
  "org.scalatest"     %% "scalatest"    % Version.Scalatest % "test"
)

lazy val root = project.in(file(".")).aggregate(util, akkaCamel, akkaPersistence, akkaStream)

lazy val util = project.in(file("streamz-util"))

lazy val akkaCamel = project.in(file("streamz-akka-camel")).dependsOn(util)

lazy val akkaPersistence = project.in(file("streamz-akka-persistence")).dependsOn(util)

lazy val akkaStream = project.in(file("streamz-akka-stream")).dependsOn(util)

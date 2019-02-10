lazy val akkaHttpVersion = "10.1.6"
lazy val akkaVersion = "2.5.19"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.jvsoftware",
      scalaVersion := "2.12.7"
    )),
    name := "delivervee",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,

      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
      "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
      "org.scalatest" %% "scalatest" % "3.0.5" % Test,
      "com.typesafe" % "config" % "1.3.2",
      "com.softwaremill.sttp" %% "core" % "1.5.8",
      "com.lihaoyi" %% "upickle" % "0.7.1"
    )
  )
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

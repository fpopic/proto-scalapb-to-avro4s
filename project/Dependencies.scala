import sbt._

object Dependencies {
  val avro4sVersion = "3.0.9"
  val scalaPBVersion = scalapb.compiler.Version.scalapbVersion
  val scalaTestV = "3.2.0"
  val scalaTestPlusJUnitV = "3.2.0.0"

  val avro4s = "com.sksamuel.avro4s" %% "avro4s-core" % avro4sVersion
  val scalapbRuntime = "com.thesamet.scalapb" %% "scalapb-runtime" % scalaPBVersion % "protobuf"
  val scalatest = "org.scalatest" %% "scalatest" % scalaTestV % Test
  val scalatestPlusJUnit = "org.scalatestplus" %% "junit-4-12" % scalaTestPlusJUnitV % Test
}

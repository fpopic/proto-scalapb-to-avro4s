import Dependencies._

lazy val root = (project in file("."))
  .settings(
    name := "proto-scalapb-to-avro4s",
    version := "0.1",
    scalaVersion := "2.13.3",
    libraryDependencies ++= scalapbRuntime :: avro4s :: scalatest :: scalatestPlusJUnit :: Nil,
    Compile / PB.includePaths := Seq(
      target.value / "protobuf_external",
      baseDirectory.value / "protobuf"
    ),
    Compile / PB.protoSources := Seq(
      baseDirectory.value / "protobuf" / "my_case_class_with_fields_annotation.proto",
      baseDirectory.value / "protobuf" / "my_case_class_with_enum.proto"
    ),
    Compile / PB.targets := Seq(scalapb.gen() -> (sourceManaged in Compile).value),
    Test / PB.targets := Seq(scalapb.gen() -> (sourceManaged in Test).value)
  )

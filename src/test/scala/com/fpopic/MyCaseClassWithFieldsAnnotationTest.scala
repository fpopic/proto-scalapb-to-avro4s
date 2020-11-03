package com.fpopic

import com.sksamuel.avro4s.{AvroSchema, FieldMapper, SnakeCase}
import org.apache.avro.SchemaBuilder
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers


class MyCaseClassWithFieldsAnnotationTest extends AnyFlatSpec with Matchers {

  "avro4s" should "use @AvroName annoation overriding Snake fieldMapper." in {
    implicit val snake: FieldMapper = SnakeCase

    val actualSchema = AvroSchema[MyCaseClassWithFieldsAnnotation]

    val expectedSchema = SchemaBuilder
      .record("MyCaseClassWithFieldsAnnotation")
      .namespace("com.fpopic")
      .fields()
      .optionalLong("event_ts")
      .optionalString("e2e_id") // instead of e2_e_id
      .endRecord()

    actualSchema mustEqual expectedSchema
  }
}

package com.fpopic

import com.sksamuel.avro4s.{AvroSchema, Encoder, FieldMapper, SchemaFor}
import org.apache.avro.{Schema, SchemaBuilder}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class MyCaseClassWithEnumTest extends AnyFlatSpec with Matchers {

  "avro4s" should "convert Enum to String." in {

    implicit def enumEncoder[E <: scalapb.GeneratedEnum]: Encoder[E] = new Encoder[E] {
      override def encode(e: E, schema: Schema, fieldMapper: FieldMapper): AnyRef = e.name
    }

    val actualSchema = AvroSchema.apply[MyCaseClassWithEnum]

    val expectedSchema = SchemaBuilder
      .record("MyCaseClassWithFieldsAnnotation")
      .namespace("com.fpopic")
      .fields()
      .optionalString("color")
      .endRecord()

    println(actualSchema.toString(true))
    println(expectedSchema.toString(true))

    actualSchema mustEqual expectedSchema
  }
}

# proto-scalapb-to-avro4s

The idea is to define [@AvroName](https://github.com/sksamuel/avro4s#overriding-a-field-name) annotations in proto 
files using ScalaPB [field options](https://scalapb.github.io/docs/customizations#adding-annotations).

```
Kafka[Protobuf] -> ScalaPB (Apache Beam/Scala) -> Avro4s -> BigQuery[Avro/TableRow/TableSchema]
```

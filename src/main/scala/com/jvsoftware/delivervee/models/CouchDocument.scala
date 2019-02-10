package  com.jvsoftware.delivervee.models

case class CouchDocument(
  // id and rev are optional because we probably don't want to be setting it
  id: String,
  rev: Option[String] = None,
  sku: String,
  cost: Double,
  quantity: Int
)
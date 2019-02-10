package com.jvsoftware.delivervee.services

import com.jvsoftware.delivervee.config.AppConfig
import com.jvsoftware.delivervee.models.CouchDocument
import com.softwaremill.sttp._
import upickle.default._

object OrderManagerService extends App {

  val db = AppConfig.ordersDb
  implicit val backend = HttpURLConnectionBackend()

  def orders: Id[Response[String]] = {
    val allDocsView: String = "/_all_docs"
    val viewPath = s"$db$allDocsView"
    sttp
      .get(uri"$viewPath")
      .send()
  }

  def getDocument(docId: String): Id[Response[String]] = {
    val docPath = s"$db/$docId"
    sttp
      .get(uri"$docPath")
      .send()
  }

  def createDocument(doc: CouchDocument): Id[Response[String]] = {
    def documentToMap(doc: CouchDocument): Map[String, String] = {
      (Map[String, String]() /: doc.getClass.getDeclaredFields) { (a, f) =>
        f.setAccessible(true)
        a + (f.getName -> f.get(doc).toString)
      }
    }
    val url = s"${AppConfig.ordersDb}/${doc.id}"
    sttp
      .body(write(documentToMap(doc)))
      .put(uri"$url")
      .send()
  }
}

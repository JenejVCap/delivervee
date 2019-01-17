package com.jvsoftware.delivervee.scala.services

import com.typesafe.config.{Config, ConfigFactory}
object AppConfig {
  val config: Config = ConfigFactory.load("application.conf")
  val databaseName = config.getString("orderPersistence.databaseName")
}

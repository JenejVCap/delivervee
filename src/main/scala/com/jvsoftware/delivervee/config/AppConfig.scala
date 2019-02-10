package com.jvsoftware.delivervee.config

import com.typesafe.config.{Config, ConfigFactory}

object AppConfig {
  val config: Config = ConfigFactory.load("application.conf")
  val ordersDb = config.getString("orderPersistence.databaseUrl")
}

package com.jvsoftware.delivervee

import com.jvsoftware.delivervee.scala.services.AppConfig

object OrderManagerService extends App {
  println("hello world")
  println(AppConfig.databaseName)
}
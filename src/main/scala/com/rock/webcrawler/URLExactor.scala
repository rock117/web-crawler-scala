package com.rock.webcrawler

import akka.actor.Actor
import scala.collection.mutable.ArrayBuffer

object URLExactor {
  private val urlRegex = "\\bhttp[s]?\\://[^'\"\\s]+".r
  def extract(html: String): ArrayBuffer[String] = {
    var urls = ArrayBuffer.empty[String]
    val vec = for (matchedUrl <- urlRegex.findAllIn(html)) yield matchedUrl
    urls ++= vec
    urls
  }
}
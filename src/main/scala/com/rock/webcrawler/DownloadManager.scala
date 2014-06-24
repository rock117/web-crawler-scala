package com.rock.webcrawler

import akka.actor.Actor
import akka.actor.Props
import scala.collection.mutable.ArrayBuffer

class DownloadManager extends Actor {
  var stop = false;
  def receive = {
    case DownloadLink(url) => dispatchTasks(ArrayBuffer(url))
    case DownloadLinks(urls) => dispatchTasks(urls)
  }

  def dispatchTasks(urls: ArrayBuffer[String]) {
    for (url <- urls) {
      val worker = context.actorOf(Props[DownloadWorker])
      worker ! url
    }
//     for (i <- 1 to 12345678) {
//      val worker = context.actorOf(Props[DownloadWorker])
//      worker ! ""
//      Thread.sleep(100)
//    }
  }
}
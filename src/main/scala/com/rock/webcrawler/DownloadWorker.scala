package com.rock.webcrawler

import akka.actor.Actor
import com.rock.webcrawler.http.Http
import com.rock.webcrawler.http.HttpResponse
import com.rock.webcrawler.storage.Storage
import com.rock.webcrawler.cfg.CrawlConfiguration
import com.rock.webcrawler.mimetype.MimeType
import com.rock.webcrawler.rule.RegexStrategy
import akka.actor.ActorRef
import scala.collection.mutable.ArrayBuffer

class DownloadWorker() extends Actor {

  override def receive = {
    case url: String if CrawlConfiguration.getCrawlStrategy.isMatch(url) =>
      val data = Http.get("http://www.baidu.com")
      System.out.println("crawl:" + url)
      process(url, data)
  }
  def process(url: String, data: HttpResponse) = {

    var storage = CrawlConfiguration.getStorageFactory.newStorage
    storage.store(url, data.data)
    if (data.mimeType == MimeType.TEXT) {
      System.out.println("data len:" + data.data.length)
      val html = new String(data.data)

      val urls = URLExactor.extract(html)
      if (!urls.isEmpty) sender ! DownloadLinks(urls)
    }
    context.stop(self) // stop or would out of memory
  }

  override def postStop = {
    System.out.println("actor stop!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!S");
  }
  def tmp2 = {
    val arr = ArrayBuffer.empty[String]
    for (i <- 1 to 30) {
      arr += "http://www.baidu.com"
    }
    println("size:" + arr.length)
    arr
  }

  def tmp() = {
    val arr = ArrayBuffer.empty[String]
    for (i <- 1 to 30) {
      arr += "http://www.baidu.com"
    }
    println("size:" + arr.length)
    arr
  }
}
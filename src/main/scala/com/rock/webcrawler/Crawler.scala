package com.rock.webcrawler

import com.rock.webcrawler.rule.CrawlStrategy
import akka.actor.ActorSystem
import akka.actor.Props
import com.rock.webcrawler.rule.CrawlStrategy

class Crawler private (var crawlRule: CrawlStrategy) {

  def launch = {
    val rootLink = ""
    val system = ActorSystem("CrawlSystem")
    val manager = system.actorOf(Props[DownloadManager])
    manager ! DownloadLink(rootLink)
  }
}
object Crawler {
  def newInstance(crawlRule: CrawlStrategy) = {
    new Crawler(crawlRule)
  }
}
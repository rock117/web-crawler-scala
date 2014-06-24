package com.rock.webcrawler.main

import akka.actor.ActorSystem
import akka.actor.Props
import com.rock.webcrawler.DownloadManager
import com.rock.webcrawler.DownloadLink
import com.rock.webcrawler.rule.SameHostStrategy
import com.rock.webcrawler.cfg.CrawlConfiguration

object Main extends App {
	CrawlConfiguration.setRootFilePath("d:/temp")
  	val rootLink = "http://yl.duowan.com/1404/261762773990.html"
  	val system = ActorSystem("CrawlSystem")
  	val manager = system.actorOf(Props[DownloadManager])
  	manager ! DownloadLink(rootLink)
 
}
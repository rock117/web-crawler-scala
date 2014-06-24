package com.rock.webcrawler.rule

import com.rock.webcrawler.util.FilenameUtil

class SameHostStrategy extends CrawlStrategy {
  def isMatch(url: String) = {
	  val (host, _) = FilenameUtil.splitUrl(url)
	  val rootHost = ""
	  host == rootHost
  }
  
  def +(strategy: SameHostStrategy) = {
     Set(this)+strategy
  }
}

object SameHostStrategy{
  def apply = new SameHostStrategy
}
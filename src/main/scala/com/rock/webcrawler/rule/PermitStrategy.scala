package com.rock.webcrawler.rule

class PermitStrategy extends CrawlStrategy{
	override def isMatch(url:String) = true
}
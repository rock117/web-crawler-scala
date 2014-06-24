package com.rock.webcrawler.rule

class RegexStrategy(val rule:String) extends CrawlStrategy{
	def isMatch(url:String) = {
		rule.matches(url)
	}
}
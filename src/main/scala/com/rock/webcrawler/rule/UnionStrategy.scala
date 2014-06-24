package com.rock.webcrawler.rule

import scala.collection.mutable.ArrayBuffer

class UnionStrategy(rules: ArrayBuffer[CrawlStrategy]) extends CrawlStrategy {
  def this() {
    this(ArrayBuffer())
  }
  def isMatch(url: String): Boolean = {
    for (rule <- rules) {
      if (rule.isMatch(url)) {
        return true
      }
    }
    false
  }
}
package com.rock.webcrawler.rule

import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.Seq

trait CrawlStrategy {
  def isMatch(url: String): Boolean
  def +(strategy: CrawlStrategy) = {
     Set(this)+strategy
  }
  
}
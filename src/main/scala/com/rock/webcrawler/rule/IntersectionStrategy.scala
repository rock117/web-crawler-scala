package src.com.rock.webcrawler.rule

import scala.collection.mutable.ArrayBuffer
import com.rock.webcrawler.rule.CrawlStrategy
import com.rock.webcrawler.rule.CrawlStrategy

class IntersectionStrategy(rules: ArrayBuffer[CrawlStrategy]) extends CrawlStrategy {
  def this() = this(ArrayBuffer.empty)
  def isMatch(url: String): Boolean = {
    var matchNum = 0
    for (rule <- rules) {
      if (rule.isMatch(url)) {
        matchNum += 1
      }
    }
    matchNum == rules.length
  }
}
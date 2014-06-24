package com.rock.webcrawler.cfg

import com.rock.webcrawler.storage.Storage
import com.rock.webcrawler.storage.FileStorage
import com.rock.webcrawler.storage.FileStorageFactory
import com.rock.webcrawler.rule.PermitStrategy
import com.rock.webcrawler.rule.CrawlStrategy
import com.rock.webcrawler.rule.RegexStrategy

object CrawlConfiguration {
	private var depth = Integer.MAX_VALUE
	private var rootFilePath = System.getProperty("user.dir")
	private var storageFactory = new FileStorageFactory
	private var crawlStrategy:CrawlStrategy = new PermitStrategy
	
	def getCrawlStrategy = crawlStrategy
	def setCrawlStrategy(crawlStrategy:CrawlStrategy) = this.crawlStrategy = crawlStrategy
	
	def setRootFilePath(rootPath:String) = this.rootFilePath = rootPath
	
	
	def getRootFilePath = rootFilePath
	def getStorageFactory = {
	  storageFactory
	}
	def setDepth(depth:Int){
	  this.depth = depth
	}
}
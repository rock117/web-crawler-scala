package com.rock.webcrawler.storage

trait Storage {
	def store(url:String, data:Array[Byte])
}
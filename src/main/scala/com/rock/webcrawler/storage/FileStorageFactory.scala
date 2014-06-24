package com.rock.webcrawler.storage

class FileStorageFactory extends StorageFactory{
	private var rootDir = System.getProperty("user.dir")
	override def newStorage = {
			new FileStorage
	}
}
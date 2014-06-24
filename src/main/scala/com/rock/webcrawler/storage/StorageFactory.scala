package com.rock.webcrawler.storage

trait StorageFactory {
  def newStorage: Storage
}
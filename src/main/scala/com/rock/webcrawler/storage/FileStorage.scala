package com.rock.webcrawler.storage

import com.rock.webcrawler.io.File
import com.rock.webcrawler.util.FilenameUtil
import com.rock.webcrawler.cfg.CrawlConfiguration

class FileStorage extends Storage {
  override def store(url: String, data: Array[Byte]) = {
    val (dir, name) = FilenameUtil.splitUrl(url)
    val fileName = FilenameUtil.joinPaths(CrawlConfiguration.getRootFilePath, dir, name)
    var absDir = FilenameUtil.joinPaths(CrawlConfiguration.getRootFilePath, dir)
    if (!File(absDir).isExist) {
      File.mkdirs(absDir)
    }
    File(fileName, true).write(data).close
  }
}
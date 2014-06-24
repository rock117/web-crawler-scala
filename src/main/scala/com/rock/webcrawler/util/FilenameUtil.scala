package com.rock.webcrawler.util

object FilenameUtil {

  def splitUrl(url: String) = {
    var cloneUrl = url
    cloneUrl = cloneUrl.replace("https://", "").replace("http://", "")

    var nameIndex = cloneUrl.lastIndexOf('/')
    var name = cloneUrl.substring(nameIndex + 1).split("#|\\?")(0)
    var relativeDir = cloneUrl.substring(0, nameIndex).replace('.', '/')
    if (name == "") {
      name = "index.html"
    }
    (relativeDir, name)
  }

  def joinPaths(paths: String*) = {
    val resBf = new StringBuffer
    for (path <- paths) {
      var pathTojoin = path
      if (!pathTojoin.endsWith("/") && !pathTojoin.endsWith("\\")) pathTojoin = pathTojoin + "/"
      resBf.append(pathTojoin)
    }

    var res = resBf.toString()
    if (res.endsWith("/") || res.endsWith("\\")) {
      res = res.substring(0, res.length() - 1)
    }
    res
  }

  def fromUrl(url: String) = {

  }
}
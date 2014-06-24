package com.rock.webcrawler.mimetype

import javax.xml.soap.Text

case class MimeType private {

}
object MimeType {
  val TEXT = new MimeType
  val BINARY = new MimeType
  val TEXT_HTML = new MimeType
  val JAVASCRIPT_APPLICATION = new MimeType
  val CSS = new MimeType
  
  
  def getInstance(mType: String) = {
    mType match {
      case null => TEXT
      case str: String if str.trim().isEmpty => TEXT
      case str: String if str.toLowerCase().matches(".*\\btext\\b.*") => TEXT
      case _ => BINARY

    }

  }

}
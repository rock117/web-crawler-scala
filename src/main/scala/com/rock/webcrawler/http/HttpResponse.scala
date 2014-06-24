package com.rock.webcrawler.http

import com.rock.webcrawler.mimetype.MimeType

class HttpResponse(val code: Int, val data: Array[Byte], mimeType: MimeType, val ex: Exception) {
  var mimeType = MimeType.TEXT
  def this(code: Int, data: Array[Byte]) = {
    this(code, data, MimeType.TEXT, null)
  }
}

object HttpResponse {
  def apply(code: Int, data: Array[Byte]) = new HttpResponse(code, data)
  def apply(code: Int, data: Array[Byte], ex: Exception) = new HttpResponse(code, data, MimeType.TEXT, ex)
  def apply(code: Int, data: Array[Byte], mimeType: MimeType) = new HttpResponse(code, data, mimeType, null)
  def apply(code: Int, data: Array[Byte], mimeType: MimeType, ex: Exception) = new HttpResponse(code, data, mimeType, ex)

}
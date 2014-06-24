package com.rock.webcrawler.http

import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.methods.GetMethod
import com.rock.webcrawler.mimetype.MimeType
import org.apache.commons.httpclient.HttpMethod
import org.apache.commons.httpclient.methods.PostMethod
import java.io.InputStream
import com.rock.webcrawler.io.File

object Http {

  def get(url: String) = {
    request(new GetMethod(url))
  }
  def post(url: String) = {
    request(new PostMethod(url))
  }

  def get(url: String, f: (Array[Byte], Int, Int) => Unit) = {
    request(new GetMethod(url),f)
  }

  private def request(method: HttpMethod, f: (Array[Byte], Int, Int) => Unit) = {

    try {
      val client = new HttpClient
      val code = client.executeMethod(method)
      val resType = method.getResponseHeader("Content-Type").getValue
      val in = method.getResponseBodyAsStream
      var len = 0;
      val buf = new Array[Byte](1024)
      len = in.read(buf)
      while (len > 0) {
        f(buf, 0, len)
        len = in.read(buf)
      }
      HttpResponse(code, null, MimeType.getInstance(resType))
    } catch {
      case e: Exception =>
        println(e.toString())
        HttpResponse(-1, null, e)
    } finally {
      method.releaseConnection()
    }

  }

  private def request(method: HttpMethod) = {
    try {
      val client = new HttpClient
      val code = client.executeMethod(method)
      val data = method.getResponseBody
      val resType = method.getResponseHeader("Content-Type").getValue
      HttpResponse(code, data, MimeType.getInstance(resType))
    } catch {
      case e: Exception =>
        println(e.toString())
        HttpResponse(-1, null, e)
    } finally {
      method.releaseConnection()
    }
  }
}
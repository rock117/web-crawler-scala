package com.rock.webcrawler.io
import java.io.{ File => JavaFile }
import java.io.FileOutputStream
import java.io.FileInputStream
import java.io.ByteArrayOutputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import scala.collection.mutable.ArrayBuffer
import java.util.Date
class File(val name: String, val createNew: Boolean) {
  private var out: FileOutputStream = null
  private var in: FileInputStream = null
  private var reader: BufferedReader = null
  private val jFile = new JavaFile(this.name)
  def this(name: String) = {
    this(name, false)
  }

  def isExist = {
    jFile.exists
  }
  def isFile = {
    jFile.isFile
  }
  def isDirectory = {
    jFile.isDirectory
  }
  def listFiles = {
    val files = jFile.listFiles()
    for (jf <- files) yield jf.getAbsolutePath
  }
  def write(data: Array[Byte]) = {
    initWriter
    out.write(data)
    this
  }
  def write(data: String): File = {
    initWriter
    this.write(data.getBytes())
    this
  }
  private def initReader {
    if (in == null) {
      in = new FileInputStream(name)
      reader = new BufferedReader(new InputStreamReader(in))
    }
  }
  private def initWriter {
    if (out == null) {
      out = new FileOutputStream(name, createNew)
    }
  }
  def read = {
    initReader
    val data = new ByteArrayOutputStream()
    var buf = new Array[Byte](1024)
    var len = in.read(buf)
    while (len > 0) {
      data.write(buf, 0, len)
      len = in.read(buf)
    }
    data.toByteArray()
  }

  def read(buf: Array[Byte]): Int = {
    initReader
    in.read(buf)
  }

  def read(buf: Array[Byte], off: Int, len: Int): Int = {
    initReader
    in.read(buf, off, len)
  }

  def readAsString = {
    new String(read)
  }
  def readLine = {
    initReader
    reader.readLine
  }
  def readLines = {
    var lines = ArrayBuffer[String]()
    var line = readLine
    while (line != null) {
      lines += line
      line = readLine
    }
    lines
  }
  def close = {
    out.close
    this
  }
}
object File {
  def apply(fileName: String) = new File(fileName)
  def apply(fileName: String, createNew: Boolean) = new File(fileName, createNew)
  def mkdir(fileName: String) {
    val dir = new JavaFile(fileName)
    if (!dir.exists) {
      dir.mkdir
    }
  }
  def mkdirs(fileName: String) {
    val dir = new JavaFile(fileName)
    if (!dir.exists) {
      dir.mkdirs 
    }
  }
  def touch(fileName: String) {
	  var file =  new JavaFile(fileName)
	  if(file.exists()){
	    file.setLastModified(new Date().getTime())
	  }
	  else{
	    new FileOutputStream(fileName).close()
	  }
  }
}
object TestFile extends App {
  val file = new File("e:/tmp.html")
  val lines = file.readLines
  for (line <- lines) {
    println(line)
  }
}










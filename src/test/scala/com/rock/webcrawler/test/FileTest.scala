package com.rock.webcrawler.test
import java.io._
import scala.collection.mutable.Stack

object FileTest extends App {

    travelDir("D:/")
    def travelDir(dir: String) {
        var stack = Stack[String]()
        stack = stack push dir
        while (!stack.isEmpty) {
            val fileName:String = stack.pop
            println(fileName)
            val file = new File(fileName)
            if (file.isDirectory()) {
                val files = file.listFiles.map(file => file.getAbsolutePath())

                for (fname <- files) {
                    stack.push(fname)
                }

            }
        }
    }

}
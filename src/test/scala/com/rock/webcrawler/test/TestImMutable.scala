package com.rock.webcrawler.test

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Set
import com.rock.webcrawler.rule.RegexStrategy
import com.rock.webcrawler.rule.PermitStrategy
import scala.collection.mutable.LinkedList

object TestImMutable extends App {

//  var r1 = new RegexStrategy("")
//  var r2 = new PermitStrategy()
//  var r3 = new PermitStrategy()
//  val rs = r1 + r2 + r3
//  println(rs.size)
//
//  val str = """ abc 
//       123 sss """
//  println(str)
  
    
    testArrayBuffer
    
  def testArrayBuffer{
      var arr = ArrayBuffer.empty[Int]
      arr+=1
      println(arr ++ Array(2,3))
      arr ++= Array(4,5)
      println(arr)
      arr.+=:(6)
       println(arr)
      arr.++=:(Array(7,8))
       println(arr)
      val list = LinkedList.empty[Int]
      println(list)
  }
  
}
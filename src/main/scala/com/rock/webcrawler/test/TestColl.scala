package com.rock.webcrawler.test

import scala.collection.immutable.List
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ArrayBuilder
import scala.collection.mutable.LinkedList

object TestColl extends App{
  
//  testList
//  testMap
//  testArrBuff
  testLinkedList
  def testLinkedList{
    var list = LinkedList[Int](1,2,3)
      list ++= Array(4,5)
    println(list)
  }
  
  def testArrBuff{
    var a = ArrayBuffer(1,2,3)
    a ++= ArrayBuffer(4,5,6)
    println(a)
  }
  
	def testList{
//	  	val list = List[String]()
	  	val list = ArrayBuffer()
	  	val l1 = list ++ Set(1,2,3,3,4)
	  	println(l1.size)
	}
  
  def testMap{
    val map = Map("id"->123, "name"->"john")
    val li = map ++ List(1,2,3)
     println(li)
    println(li.size)
  }
}
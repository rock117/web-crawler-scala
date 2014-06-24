package com.rock.webcrawler.test

object Test extends App {
    def foo(x: Array[Int]) = x.foldRight(100)((a, b) => a - b) //println(x)
    println("Hello World!")
    println(foo(Array(1,2,0)))

    //    class Pair[+T] (val first: T, val second: T)
    //    class Person
    //    class Student extends Person
    //    
    //    def makeFriends(p:Pair[Student]){
    //        println(p)
    //    }
    //    
    //    var p = new Pair[Person](new Person(), new Person())
    //    var s = new Pair[Student](new Student(),new Student())

    //    makeFriends(p)
    //    makeFriends(s)
}




